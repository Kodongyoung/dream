import React, {useState} from 'react'
import {Route} from 'react-router-dom'
import Home from './common/Home'
import ChatAdd from './chat/ChatAdd'
import ChatList from './chat/ChatList'
import ChatDetail from './chat/ChatDetail'

const App = () => {
  return(<>
  <Route path="/" component={Home} exact/>
  <Route path="/ChatAdd" component={ChatAdd} />
  <Route path="/ChatList" component={ChatList} />
  <Route path="/ChatDetail/:id" component={ChatDetail} /> 

  </>)
}

export default App