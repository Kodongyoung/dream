import axios from "axios";
import React, { useCallback, useEffect, useState } from "react"

const ChatDetail = (props) => {

    const [message, setMessage] = useState({});

    const readOne = () => {
        axios.get(`http://localhost:8080/chats/${props.match.params.id}`)
        .then(res => {
            setMessage(res.data)
        })
        .catch(err => {
            console.log(err)
        })
    }

    const handleChange = useCallback( e => {
        const {name, value} = e.target;
        setMessage({...message, [name] : value});
    },[message]);

    const update = () => {
        axios.put(`http://localhost:8080/chats/${props.match.params.id}` ,  message)
        .then(res => {
            setMessage(res.data)
    
        })
        .catch(err => {
            console.log(err)
        })

    }

    useEffect(() => {
        
        readOne()}, [])

    return(<>
    <form onSubmit = {(e)=> e.preventDefault()}>

        <input type="text" name="message" value={message.message || ""} 
            onChange = {handleChange} />

        <button type="submit" onClick={update}>수정</button>
    
     </form>
    
    </>)
}

export default ChatDetail