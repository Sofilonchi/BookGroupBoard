import NiceDates from "./NiceDates"
import "../styles/MessageCard.css"

const MessageCard = (props) =>{

    const { theMessage } = props

    return(
        <div className="MessageCard">    
            <p className="MessageUserName"> {props.user} </p>
            <p className="MessageDate">Date: <NiceDates time ={props.date} /></p>
            <ul className="MessageMessage">
                <li> {props.message} </li>
            </ul>
        </div>
    )
}

export default MessageCard