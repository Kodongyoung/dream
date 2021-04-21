import React, { useEffect , useState } from "react"
import axios from "axios"
import { Link } from "react-router-dom" 


const ChatList = () => {
  const [message, setMessage] = useState()

  const readAll = () => {
    axios.get(`http://localhost:8080/chats`)
    .then(res => {
      setMessage(res.data)
    })
    .catch(err => {
      console.log(err)
    })
  }

  useEffect(() => readAll(), [])

  return(<>
  <h3> List </h3>
  <table border="2">
  <thead>
       <tr>
          <th align="center" width="50">선택</th>
          <th align="center" width="80">번호</th>
          <th align="center" width="600">채팅내용</th>
       </tr>
       </thead>
       <tbody>
         {message ?
          message.map((message, id) => {
            return (
              <tr key={id}>
                  <td align="center"><input type="checkbox"/></td>
                  <td align="center">{message.boardNo}</td>
                  <td align="center"><Link to={`/ChatDetail/${message.boardNo}`}>{message.message}</Link></td>          
              </tr>                   
            )
            }) : 
          <tr><td colSpan="4">List is empty</td></tr>}
            </tbody>
  </table>
  
  
  </>)
}

export default ChatList