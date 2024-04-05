import { useNavigate, useParams } from "react-router-dom"
import { useState } from "react"
import { Button } from "@mui/material"
import * as React from 'react';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import axios from "axios";
import "../styles/NewMeeting.css"

const NewMeeting = (props) => {

    const { bearer } = props
    const {userId, bookGroupId} = useParams()
    const navigate = useNavigate()
    const [time, setTime ] = useState("")
    const [ successMessage, setSuccessMessage ] = useState("")

    const createMeeting = () => {
        console.log("Recorded time is: " + time)

        const requestOptions = {
            headers:{
                Authorization: bearer
            }
        }

        axios.get("http://localhost:8088/api/bookgroups/"+bookGroupId, requestOptions)
            .then(response=>{
                const group = response.data

                const meeting = {
                    date:time,
                    bookGroup:group
                }

                axios.post("http://localhost:8088/api/meetings", meeting, requestOptions)
                .then(response=>{
                    setSuccessMessage("Meeting successfully created")
                })
    })

    }

    const  returnToBookGroup = () => {
        navigate("/BookGroup/" + userId + "/" + bookGroupId)
    }

    return (
        <>
        <div className="NewMeeting">
        <h1 className= "NewMeetingTitle"> Create a new meeting </h1>
            <div className="ChooseTime">
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                     <DateTimePicker 
                        label="Select meeting time" 
                        views={['year', 'month', 'day', 'hours', 'minutes', 'seconds']} 
                        required 
                        value={time}
                        onChange={(time) => setTime(time)}/>
                </LocalizationProvider>
            </div>
            <Button className="NewMeetingSubmit" type='submit' color='primary' variant="contained" size="medium" onClick={createMeeting}> Set Date </Button>
        
        {successMessage!=="" && <p style={{color:"green"}}>{successMessage}</p>}
        </div>
        <Button color='primary' variant='outlined' size='medium' onClick={returnToBookGroup}>Return to Book Group Page</Button>
        </>
    )

}

export default NewMeeting

