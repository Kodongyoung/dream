import React , { useState } from 'react'
import {Link} from "react-router-dom"


const Home = () => {
    return(<>
        <div style={{width: 150, margin: "0 auto"}}><h1>Home</h1>
        <Link to={"ChatAdd"}>Create</Link><br/>
        <Link to={"ChatList"}>List</Link>
       
        
     </div>
    </>)
}

export default Home