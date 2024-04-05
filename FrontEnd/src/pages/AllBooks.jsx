import BookCard from "../components/BookCard"
import { useState, useEffect } from "react"
import axios from 'axios'
import { Pagination } from "@mui/material"
import "../styles/AllBooks.css"
import { useNavigate, useParams } from "react-router-dom"
import { Button } from "@mui/material"

const AllBooks = () => {

    const navigate = useNavigate()
    const {bookGroupId} = useParams()
    const { userId } = useParams()

    const postsPerPage = 9
    const [ currentPage, setCurrentPage ] = useState(1)
    const [ loading, setLoading ] = useState(true)
    const [paginatedPosts, setPaginatedPosts] = useState([]);

useEffect(() => {

    const getAllBooks = async () => {
        try{
            const response = await axios.get("http://localhost:8088/api/books", {})
            const books = response.data
            const paginated = paginate(books, postsPerPage)
            setPaginatedPosts(paginated)
            setLoading(false)
        }
        catch (error){
            console.error("There was a problem fetching data: " + error)
        }
    }

    getAllBooks()

}, [])

const paginate = (books, postsPerPage) => {
    const pageCount = Math.ceil(books.length / postsPerPage)
    return Array.from({ length: pageCount }, (_, index) =>
    books.slice( index * postsPerPage, (index + 1 ) * postsPerPage))
}

const currentPosts = paginatedPosts[currentPage - 1]

    return (
        <>
        <h1 className="AllBooksTitle"> Browse Books </h1>
        <div className="BookSquaresList">
            {loading ? <p> Loading ...</p> : currentPosts.map(
                theBook =>
                    <BookCard key={theBook.id} title={theBook.title} firstName={theBook.author.fname} lastName={theBook.author.lname}/> 
            )}
        </div>
        <div className="BookListPagination">
            <Pagination
                count = {paginatedPosts.length}
                page = {currentPage}
                onChange={(_, newPage) => setCurrentPage(newPage)}
                />
        </div>
        {userId !==undefined && <Button variant="outlined" style={{marginLeft:"20px"}} onClick={()=>navigate("/BookGroup/" + userId + "/" + bookGroupId)}> Return to Book Group </Button>}
    </>
    )
}

export default AllBooks