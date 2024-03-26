import MessageCard from "../components/MessageCard"
import axios from 'axios'
import { useState, useEffect } from "react"
import {ButtonGroup, Button, styled} from '@mui/material'
import { useNavigate, useParams } from "react-router-dom"
import CurrentBook from "../components/CurrentBook"
import Meeting from "../components/Meeting"
import "../styles/BookGroup.css"

const BookGroup = (props) => {

    const navigate = useNavigate()
    const {bookGroupId} = useParams()
    const { userId } = useParams()
    const { bearer } = props

    const [ messages, setMessages ] = useState([])
    const [ currentBook, setCurrentBook ] = useState({})
    const [ meeting, setMeeting ] = useState("")
    const [ members, setMembers ] = useState([])

    useEffect(()=>{   

        const requestOptions = {
            headers:{
                Authorization: bearer
            }
        }
     
        axios.get("http://localhost:8088/api/messages/bookgroup/" + bookGroupId, requestOptions)
        .then(response=>{
            setMessages(response.data)
        })

        axios.get("http://localhost:8088/api/assignedBooks/current" + bookGroupId, requestOptions)
        .then(response => {
            setCurrentBook(response.data.book)
        })

        axios.get("http://localhost:8088/api/meetings/nextbookgroup/" + bookGroupId, requestOptions)
        .then(response => {
            setMeeting(response.data)
        })


        axios.get("http://localhost:8088/api/users/bookgroup" + bookGroupId , requestOptions)
        .then(response => {
            setMembers(response.data)
        })

    }, [bookGroupId, bearer])

    const updateDetails = () => {
        navigate("/RegisterUser/" + userId + "/" + bookGroupId)
    }
         
    return(
        <>
            <h1 className="BookGroupWelcome">Hello, Readers</h1>
            <div className="CurrentDetails">
            <CurrentBook title={currentBook.title} />
            <Meeting time={meeting.date}/>
            </div>
            <div className="BookGroup">
            <div className="messages">
            {messages.slice(0,10).map(
                theMessage => 
                <MessageCard key={theMessage.id} user={theMessage.user.username} date={theMessage.date} message={theMessage.message}/>
            )}
            </div>
            <div className="Members">   
            <h3 className="Memberstitle"> Group Members: </h3> 
           { members.map(
                theMember =>
                    <p> {theMember} </p>
            )}
            </div>
            </div>
            <div className="bookGroupButtons">
            <ButtonGroup >
            <Button size="small" variant="outlined" colour="primary" onClick={()=>navigate("/NewMessageCard/" + userId + "/" + bookGroupId)} > New Message </Button>
            <Button size="small" variant="outlined" colour="primary" onClick={()=>navigate("/Assignment/" + userId + "/" + bookGroupId)} > Assign New Book </Button>
            {meeting==="" ?
                <Button size="small" variant="outlined" colour="primary" onClick={()=>navigate("/NewMeeting/"+ userId + "/" + bookGroupId)} > Create New Meeting </Button>
            :
            <Button size="small" variant="outlined" colour="primary" disabled > Create New Meeting </Button>
            }
            <Button onClick={()=>navigate("/Books/" + userId + "/" + bookGroupId)} size="small" variant="outlined" color="secondary" > See All Books </Button> 
            <Button onClick={updateDetails} size="small" variant="outlined" color="secondary"> Update Reader Details </Button>
            </ButtonGroup>
            </div>
        </>
    )

}
export default BookGroup