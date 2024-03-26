import axios from 'axios'
import { useNavigate } from "react-router-dom"
import { Button } from '@mui/material'
import { ButtonGroup } from '@mui/material'

const HomePage = () =>{

    const navigate = useNavigate();

    const LogIn = () => {
        navigate('/login')
    }

    return(
        <div style={{display:"fixed", justifyContent: "center", margin:45}}>
            <ul style={{listStyleType:"none"}}>
            <li>
            <h1 style={{color:"rgb(141, 205, 227)", fontSize:"100px", fontWeight:450}}>Welcome</h1>
            </li>
            <ButtonGroup>
            <Button variant="outlined" color="primary" size="large" onClick={LogIn}> Log In </Button> 
            <Button variant="outlined" color="primary" size="large" onClick={()=>navigate("/register")}> Register </Button>
            </ButtonGroup>
            </ul>
        </div>
    )
}
export default HomePage