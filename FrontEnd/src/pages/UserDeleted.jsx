import { Button } from "@mui/material"
import { useNavigate } from "react-router-dom"


const UserDeleted = () => {

    const navigate = useNavigate()

    const returnHome =() =>{
        navigate("/")
    }

return(
    <>
    <h2 style={{color:"black", fontSize:"40px", fontWeight:"200"}}>Reader has been successfully deleted</h2>
    <Button style={{size:"large"}} variant="outlined" color="primary" onClick={returnHome}>Return to Home Page</Button>
    </>
)

}

export default UserDeleted