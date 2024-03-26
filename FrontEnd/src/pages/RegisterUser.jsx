import { useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import axios from 'axios'
import { InputLabel, MenuItem, Select, Button, FormControl, FormHelperText} from '@mui/material'
import "../styles/UserPage.css"

const RegisterUser = (props) =>{

    const navigate = useNavigate()

    const [bearer, setBearer] = props.bearer
    const [name, setName] = useState("") 
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [genre, setGenre] = useState("")
    const [genreId, setGenreId] = useState("1")
    const [location, setLocation] = useState("")
    const [locationId, setLocationId] = useState("1")
    const {userId, bookGroupId} = useParams()
    const [successMessage, setSuccessMessage ] = useState("")
    const [bookGroup, setBookGroup] = useState("")
    const [errorMsg, setErrorMsg] = useState("")


    const createUser = (event) => {

        event.preventDefault()
        let newErrorMsg = ""
        
        axios.get("http//localHost:8088/api/genres/" + genreId)
        .then(response=>{
            const genreName = response.data.name
            axios.get("http//localHost:8088/api/locations/" + locationId)
            .then(response=>{
                const locationName = response.data.name
                const endpoint = "http://localhost:8088/api/users"
                if (userId==undefined){
        
                    axios.get("http://localhost:8088/api/users/checkusername/" + username)
                    .then(response=>{
                        if (response.error !== undefined){
                            console.log(response.error)
                            return setErrorMsg("This username is taken, please choose another")
                        }
                        else{
                            axios.get("http://localhost:8088/api/bookgroups/" + genreId + "/" + locationId)
                            .then(response=>{
                               
                                let thegroup = response.data
                                if (thegroup.length === 0 ){
                                    setErrorMsg("There are no suitable book groups at this time")
                                    return
                                }
                                let thisGroup = thegroup[0]

                                const user = {
                                    username,
                                    password,
                                    name,
                                    location:{id:locationId, name:locationName},
                                    genre:{id:genreId, name:genreName},
                                    bookGroup:thisGroup
                                }
                                    axios.post(endpoint, user)
                                    .then(response=>{
                                        setSuccessMessage("Reader successfully created, please log in to see your book group")
                                })
                            })
                        }
                    })
                }   
                else{
                    axios.get("http://localhost:8088/api/bookgroups/" + bookGroupId)
                    .then(response=>{ 
                        const group = response.data
                        const user = {
                            username,
                            password,
                            name,
                            location:{id:locationId, name:locationName},
                            genre:{id:genreId, name:genreName},
                            bookGroup:group
                        }
                        axios.put(endpoint, {...user, id:userId})
                        .then(response=>{
            
                            axios.get("http://localhost:8088/api/users/user" + userId)
                            .then(response=> {
                                setSuccessMessage("Reader Updated")
                            })
                            
                        })
                    .catch(err=>setErrorMsg("Something went wrong while updating your details"))
                }
            )
                }
        })

        setErrorMsg(newErrorMsg)
    })
}

    const returnToBookGroup = () => {

        navigate("/BookGroup/" + userId + "/" + bookGroupId)

    }

    const LogIn = () => {

        navigate('/login')

    }

    const deleteUser = async () => {

            const requestOptions = {
                headers:{
                    Authorization: bearer
                }
            }
  
            try {
              await axios.delete("http://localhost:8088/api/users/delete/" + userId, requestOptions);
              console.log("Reader deleted:");
            } catch (error) {
              console.error("Error deleting reader:", error);
            }

            setBearer(0)
            navigate("/userDeleted")
          };

    return(
        <>
        <div className="UserForm">
            <h1 className="UserTitle">{userId===undefined ? "Create New Reader" : "Edit Reader Details"}</h1>
            <form onSubmit={()=>createUser(event)} >
                {userId!=undefined && <p> Updating {username} details</p>}
                <ul className="UserDetails">
                    <li className="textBox">
                        <label htmlFor="name">Name </label>
                        <input required id="name" value={name} onChange={(event)=>setName(event.target.value)}/>
                    </li>
                    <li className="textBox">
                        <label htmlFor="username">Username </label>
                        <input required id="Username: " value={username} onChange={(event) => setUsername(event.target.value)}/>
                    </li>
                    <li className="textBox"> 
                        <label htmlFor="password">Password </label>
                        <input required id="password" value={password} onChange={(event) => setPassword(event.target.value)}/>
                    </li>
                    <li className="userSelect">
                        <InputLabel id="location-label"></InputLabel>
                        <FormHelperText> Location </FormHelperText>
                        <Select
                        labelId="location-label"
                        id="location"
                        value={locationId}
                        onChange={event => setLocationId(event.target.value)}
                        >
                            <MenuItem value={"1"}>South East</MenuItem>
                            <MenuItem value={"2"}>North</MenuItem>
                            <MenuItem value={"3"}>West</MenuItem>
                            <MenuItem value={"4"}>East</MenuItem>
                            <MenuItem value={"5"}>Inner City</MenuItem>
                        </Select>
                        </li>
                        <li className="userSelect">
                        <InputLabel id="genre-label"></InputLabel>
                        <FormHelperText> Genre </FormHelperText>
                        <Select
                        labelId="genre-label"
                        id="genre"
                        value={genreId}
                        onChange={event => setGenreId(event.target.value)}
                        >
                            <MenuItem value={"1"}>Best Sellers</MenuItem>
                            <MenuItem value={"2"}>All</MenuItem>
                            <MenuItem value={"3"}>All Fiction</MenuItem>
                            <MenuItem value={"4"}>Fantasy</MenuItem>
                            <MenuItem value={"5"}>Non-fiction</MenuItem>
                            <MenuItem value={"6"}>Romance</MenuItem>
                            <MenuItem value={"7"}>Classics</MenuItem>
                            <MenuItem value={"8"}>Horror/Thriller</MenuItem>
                            <MenuItem value={"9"}>Science Fiction</MenuItem>
                        </Select>
                        </li>
                        </ul>
                <Button className="UserSubmit" type="submit" size="large" color="primary" variant="contained"> Submit </Button>
                
                {successMessage!=="" && <p style={{color:"green"}}>{successMessage}</p>}
                {userId!==undefined && <Button className="DeleteUserButton" onClick={deleteUser} > Delete My Account </Button> }
                {errorMsg!="" && <p style={{color:"red"}}>{errorMsg}</p>}
            </form>
            </div>
            {userId ==undefined && <Button variant="outlined" color="primary" size="large" onClick={LogIn}> Log In </Button>}
            {userId!==undefined && <Button color='primary' variant='outlined' size='medium' onClick={returnToBookGroup}> Return to Book Group Page </Button>}
        </>
    )

}

export default RegisterUser