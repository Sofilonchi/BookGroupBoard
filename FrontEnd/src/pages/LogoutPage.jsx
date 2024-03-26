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
        <h2> See you next time </h2>
        <Button variant="outlined" size="large" onClick={logout}> Confirm Log Out </Button>
        
        </>
    )
}

export default LogOut