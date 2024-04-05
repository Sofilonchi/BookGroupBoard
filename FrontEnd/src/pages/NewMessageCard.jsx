import {Button} from '@mui/material'
import { useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import axios from 'axios'
import '../styles/NewMessage.css'

const NewMessageCard = (props) => {

    const [ comment, setComment ] = useState("")
    const { bearer } = props
    const { userId, bookGroupId } = useParams()
    const [ successMessage, setSuccessMessage ] = useState("")
    const navigate = useNavigate()

    const createMessage = (e) => {
        
        e.preventDefault();
        const date = new Date()
        const today = date.toISOString()

        const requestOptions = {
            headers:{
                Authorization: bearer
            }
        }
    
        axios.get("http://localhost:8088/api/users/user/" + userId, requestOptions)
        .then(response=>{
            const person = response.data
            console.log(person)
            
            axios.get("http://localhost:8088/api/bookgroups/"+bookGroupId, requestOptions)
            .then(response=>{
                const bookgroup = response.data
            
                const pondering = {
                    message:comment, 
                    date:today,
                    bookGroup:bookgroup,
                    user:person
                }

                const endpoint = "http://localhost:8088/api/messages"
                axios.post(endpoint, pondering, requestOptions)
                .then(response=>{
                    setSuccessMessage("Message successfully created")
                })
            })
        })

    }

    const  returnToBookGroup = () => {
        navigate("/BookGroup/" + userId + "/" + bookGroupId)
    }

    return(
        <>
        <div className="NewMessageCard">
        <h1 className="NewMessageTitle">Create a new message</h1>
        <form onSubmit={createMessage}>
            <div className="NewMessage" >
                <label htmlFor="text" style={{marginRight:10, paddingBottom:10}}>Type your message here </label>
                <input required id="text" value={comment} onChange={(e)=> setComment(e.target.value)}/>
            </div>
            <Button className="NewMessageSubmit" type='submit' color='primary' variant='contained' size='medium'  >Post</Button>
        </form>
        {successMessage!=="" && <p style={{color:"green"}} >{successMessage}</p>}
        </div>
        <Button color='primary' variant='outlined' size='medium' onClick={returnToBookGroup}>Return to Book Group Page</Button>
        </>
    )

}

export default NewMessageCard