import Button from '@mui/material/Button'
import { useNavigate } from 'react-router-dom'
import { useState } from 'react'

const LogOut = (props) => {

    const [bearer, setBearer] = props.bearer
    const navigate = useNavigate()

    const logout = () => {

        localStorage.removeItem("token-info") 
        setBearer(0)
        navigate("/")

    }
    
    return(
        <>
        <h2 style={{color:"rgb(67, 90, 18)", fontSize:"80px", fontWeight:450}}> See you next time </h2>
        <Button style={{borderColor:"brown", color:"brown", fontSize:"20px", fontWeight:450}} variant="outlined" onClick={logout}> Confirm Log Out </Button>
        
        </>
    )
}

export default LogOut