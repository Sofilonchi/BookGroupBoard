import { useState } from 'react'
import { Routes, Route, useNavigate } from 'react-router-dom'
import HomePage from './pages/HomePage'
import LoginPage from './pages/LoginPage'
import RegisterUser from './pages/RegisterUser'
import BookGroup from './pages/BookGroup'
import LogoutPage from './pages/LogoutPage'
import NewMessageCard from './pages/NewMessageCard'
import AssignBook from './pages/Assignment'
import NewMeeting from './pages/NewMeeting'
import UserDeleted from './pages/userDeleted'
import AllBooks from './pages/AllBooks'
import './App.css'
import { Button } from '@mui/material'

function App() {
  
  const [bearer, setBearer] = useState(0)
  const navigate = useNavigate()

  return (
    <>
      <div className="NavigationBar">
      <Button className="NavbarButton" onClick={()=>navigate("/")}> Book Group Board</Button>
          {bearer===0 ?
            <>
            <Button className="NavbarButton" id="see-all-books-button" onClick={()=>navigate("/Books")}> See All Books </Button>
            </>
            :
            <> 
            <Button className="NavbarButton" id="log-out-button" onClick={()=>navigate("/logout")}> Log Out </Button>
            </>
            }
      </div>

      <Routes>
        <Route path = "/" element ={<HomePage />}/>
        <Route path="/Books" element ={<AllBooks />}/>
        <Route path="Books/:userId/:bookGroupId" element ={<AllBooks />}/>
        <Route path ="/register" element={<RegisterUser bearer={[bearer, setBearer]}/>}/>
        {bearer===0 && <Route path="/login" element ={<LoginPage bearer={[bearer, setBearer]}/>}/>}
        {bearer !==0 && <Route path="/assignment/:userId/:bookGroupId" element ={<AssignBook bearer={bearer}/>}/>}
        {bearer !==0 && <Route path = "/logout" element = {<LogoutPage bearer={[bearer, setBearer]}/>}/>}
        {bearer !==0 && <Route path = "/NewMessageCard/:userId/:bookGroupId" element ={<NewMessageCard bearer={bearer}/>}/>}
        {bearer !==0 && <Route path = "/NewMeeting/:userId/:bookGroupId" element ={<NewMeeting bearer={bearer}/>}/>}
        {bearer !==0 && <Route path="/BookGroup/:userId/:bookGroupId" element={<BookGroup bearer={bearer}/>}/>}
        {bearer !==0 ? <Route path ="/RegisterUser/:userId/:bookGroupId" element ={<RegisterUser bearer={[bearer, setBearer]}/>}/>
        :
        <Route path = "/RegisterUser" element={<RegisterUser bearer={bearer}/>}/>}
        <Route path="*" element ={<HomePage />}/>
        <Route path="/UserDeleted" element={<UserDeleted />}/>
      </Routes>
    </>
    )
}
export default App
