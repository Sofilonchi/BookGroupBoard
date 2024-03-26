import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
import Button from '@mui/material/Button'
import "../styles/LoginPage.css"

const LoginPage = (props) => {
    
    const [bearer, setBearer] = props.bearer
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [errorMessage, setErrorMessage] = useState("")

    const navigate = useNavigate();
    
    const tryLogin = (e) => {

        e.preventDefault();
        const attempt = {username, password}
        console.log(attempt)
        
        const requestOptions = {
            auth:{
                username:username,
                password:password
            }
        }
        axios.post("http://localhost:8088/api/auth/login",{},requestOptions)
            .then(response=>{
                setBearer("Bearer " + response.data)
                GetUserDetails("Bearer " + response.data)
            })
            .catch(Error=> setErrorMessage("Log in details are incorrect"))
        }

    const GetUserDetails = (bearer) => {

        const requestOptions = {
            headers:{
                Authorization: bearer
            }
        }
        console.log(requestOptions)
        axios.get("http://localhost:8088/api/users/" + username, requestOptions )
        .then(response=>{
            const userId = response.data.id
            axios.get("http://localhost:8088/api/users/findbookgroup/" + userId, requestOptions)
            .then(response=>{
                const bookGroupId = response.data.id
                navigate("/BookGroup/" + userId + "/" + bookGroupId) 
                })
        })
    }

    return(
        <div>
            <h1 className="LogIn">Log In</h1>
            <form className="LogInForm" onSubmit={tryLogin}>
                <ul className="LogInBoxes">
                <li>
                <label htmlFor="username" >Username </label> 
                <input value={username} onChange={(e)=>setUsername(e.target.value)}/>
                </li>
                <li>
                <label htmlFor="password" >Password </label> 
                <input value={password} onChange={(e)=>setPassword(e.target.value)}/>
                </li>
                </ul>
                <Button variant="outlined" color="primary" size="medium" type="submit" >Log in</Button>
                <p style={{color:"rgb(141, 205, 227)", position:"center"}}> Don't have an account? Return to home page to register </p>
                <Button variant="text" color="primary" size="small" onClick={()=>navigate("/")}>Home</Button>
            </form>
            {errorMessage !=="" && <p style={{color:"red",justifyContent:"center", display:"flex"}}>{errorMessage}</p>}
        </div>
    )
}
export default LoginPage
