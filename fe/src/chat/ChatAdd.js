import { React, useState } from "react"
import axios from "axios"

const ChatAdd = (props) => {
  const [message, setMessage] = useState('')
  const [keyboard, setKeyboard] = useState('')

  const register = () => {
    axios.post('http://localhost:8080/chats', { message })
    .then(res => {
      console.log(res)
      props.history.push('/ChatList')
      
    })
    .catch(err => {
      console.log(err)
    })
  }

  return(<> 

    <form onSubmit={(e) => e.preventDefault()}>
      <h3>create</h3>
      <table>
        <thead/>
        <tbody>
        <tr>
          <td>채팅</td>
          <td><input type="text" name="message" value={message} placeholder="내용을 입력하세요"
          onChange = { e => setMessage (e.target.value)} /></td>
        </tr>
        </tbody>
      </table>

      <button type="submit" onClick={register} >create</button>
    </form>
  </>
  )
}

export default ChatAdd