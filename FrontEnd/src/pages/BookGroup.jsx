import MessageCard from "../components/MessageCard"
import axios from 'axios'
import { useState, useEffect } from "react"
import {ButtonGroup, Button, styled, Pagination} from '@mui/material'
import { useNavigate, useParams } from "react-router-dom"
import CurrentBook from "../components/CurrentBook"
import Meeting from "../components/Meeting"
import "../styles/BookGroup.css"
import AllBooks from "./AllBooks"

const BookGroup = (props) => {

    const navigate = useNavigate()
    const {bookGroupId} = useParams()
    const { userId } = useParams()
    const { bearer } = props

    const messgesPerPage = 6
    const [ currentPage, setCurrentPage ] = useState(1)
    const [ loading, setLoading ] = useState(true)
    const [paginatedMessages, setPaginatedMessages] = useState([])
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
     
        const getAllMessages = async () => {
            try{
               const response = await axios.get("http://localhost:8088/api/messages/bookgroup/" + bookGroupId, requestOptions)
               const messages = response.data
               const paginated = paginate(messages, messgesPerPage)
               setPaginatedMessages(paginated)
               setLoading(false) 
            }
            catch (error){
                console.error("There was a problem fetching data: " + error)
            }
        }

        getAllMessages()

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

    const paginate = (messages, messgesPerPage) => {
        const pageCount = Math.ceil(messages.length / messgesPerPage)
        return Array.from({ length: pageCount }, (_, index) =>
        messages.slice( index * messgesPerPage, (index + 1 ) * messgesPerPage))
    }

    const currentMessages = paginatedMessages[currentPage - 1]

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
            {loading ? <p> Loading Messages... </p> : currentMessages.map(
                theMessage => 
                <MessageCard key={theMessage.id} user={theMessage.user.username} date={theMessage.date} message={theMessage.message}/>
            )}
            </div>
            <div className="Members">   
            <h3 className="Memberstitle"> Group Members: </h3> 
            <div className="MembersNames">
           { members.map(
                theMember =>
                    <p> {theMember} </p>
            )}
            </div>
            </div>
            </div>
            <div className="MessageListPagination">
            <Pagination
                count = {paginatedMessages.length}
                style={{"marginBottom":"20px"}}
                page = {currentPage}
                onChange={(_, newPage) => setCurrentPage(newPage)}
                />
            </div>
            <div className="bookGroupButtons">
            <ButtonGroup >
            <Button style={{color:"brown", borderColor:"brown", paddingLeft:"10px", paddingRight:"10px"}} size="small" variant="outlined" onClick={()=>navigate("/NewMessageCard/" + userId + "/" + bookGroupId)} > New Message </Button>
            <Button  style={{color:"brown", borderColor:"brown", paddingLeft:"10px", paddingRight:"10px"}} size="small" variant="outlined" onClick={()=>navigate("/Assignment/" + userId + "/" + bookGroupId)} > Assign New Book </Button>
            {meeting==="" ?
                <Button style={{color:"brown", borderColor:"brown", paddingLeft:"10px", paddingRight:"10px"}} size="small" variant="outlined" onClick={()=>navigate("/NewMeeting/"+ userId + "/" + bookGroupId)} > Create New Meeting </Button>
            :
            <Button size="small" variant="outlined" disabled > Create New Meeting </Button>
            }
            <Button onClick={()=>navigate("/Books/" + userId + "/" + bookGroupId)} size="small" variant="outlined" color="secondary" > See All Books </Button> 
            <Button onClick={updateDetails} size="small" variant="outlined" color="secondary"> Update Reader Details </Button>
            </ButtonGroup>
            </div>
        </>
    )

}
export default BookGroup