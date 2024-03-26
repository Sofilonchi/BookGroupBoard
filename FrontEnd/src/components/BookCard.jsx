import { useEffect } from "react"
import axios from "axios"
import { useState } from "react"
import "../styles/BookCard.css"

const BookCard = (props) => {

    const { theBook } = props
    const [ author, setAuthor ] = useState("")

    useEffect(() =>{
        
        axios.get("http://localhost:8088/api/books/bookAuthor/" + props.key, {})
            .then(response => {
                setAuthor(response.data)
            })
    }, [])

    return (
        <>
        <div className="BookCard">
            <p className="BookTitle"> { props.title } </p>
            <p className="BookAuthor"> By: {props.firstName} {props.lastName} </p>
        </div>
        </>
    )
}
export default BookCard