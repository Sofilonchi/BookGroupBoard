import axios from "axios"
import { InputLabel, MenuItem, Select, Button } from "@mui/material"
import { useState } from "react"
import { useParams, useNavigate } from "react-router-dom"
import "../styles/Assignment.css"


const AssignBook = (props) => {

    const [ bookId, setBookId ] = useState(1)
    const { bearer } = props
    const date = new Date()
    const now = date.toISOString()
    const { userId, bookGroupId } = useParams()
    const [successMessage, setSuccessMessage ] = useState("")
    const navigate = useNavigate()
    
    const createAssignment = (e) => {

        e.preventDefault();
        const requestOptions = {
            headers:{
                Authorization: bearer
            }
        }

        axios.get("http://localhost:8088/api/books/" + bookId, requestOptions)
        .then(response => {
            const text = response.data

            axios.get("http://localhost:8088/api/bookgroups/" + bookGroupId, requestOptions)
            .then(response=> {
                const group = response.data
           
                const assignment = { date:now, book:text, bookGroup:group }

                axios.post("http://localhost:8088/api/assignedBooks", assignment, requestOptions)
                .then(response=> {
        
                    setSuccessMessage("Book has been successfully assigned")
                })
            })
        })
    }

    const  returnToBookGroup = () => {
        navigate("/BookGroup/" + userId + "/" + bookGroupId)
    }

    return (
        <>
        <div className="NewAssignmentCard">
        <h1 className="NewAssignmentTitle"> Assign the Next Book </h1>
        <form onSubmit={createAssignment}>
            <div>
            <InputLabel id="book">Select Here</InputLabel>
                        <Select
                        style={{width: "70%", backgroundColor: "white"}}
                        book-id="book"
                        id="book"
                        value={bookId}
                        label="Book"
                        onChange={event => setBookId(event.target.value)}
                        >
                            <MenuItem value={"1"}>Anna Karenina</MenuItem>
                            <MenuItem value={"2"}>How to Stop Time</MenuItem>
                            <MenuItem value={"3"}>The Humans</MenuItem>
                            <MenuItem value={"4"}>The Midnight Library</MenuItem>
                            <MenuItem value={"5"}>Daddy Long Legs</MenuItem>
                            <MenuItem value={"6"}>Journey to the Centre of the Earth</MenuItem>
                            <MenuItem value={"7"}>Treasure Island</MenuItem>
                            <MenuItem value={"8"}>Contact</MenuItem>
                            <MenuItem value={"9"}>Small is Beautiful</MenuItem>
                            <MenuItem value={"10"}>The Beginning of Infinity</MenuItem>
                            <MenuItem value={"11"}>The Invention of Nature</MenuItem>
                        </Select>           
            </div>
            <Button className="AssignmentSubmit" type='submit' color='primary' variant='contained' size='medium'  > Assign </Button>
        </form>
        </div>
        {successMessage!="" && <p style={{color:"green"}}>{ successMessage }</p>}
        <Button color='primary' variant='outlined' size='medium' onClick={returnToBookGroup}> Return to Book Group Page </Button>
        </>
    )
}

export default AssignBook