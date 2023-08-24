import {Login} from './Page/LoginPage/Login'
import {Nav} from './Page/Nav'
import {BrowserRouter, Routes} from 'react-router-dom'

function App() {
  // const data = [25, 45, 60, 30, 10]
  // const label = ['a', 'b', 'c', 'd', 'e']
  // const backgroundColor = ['blue', 'steelblue', 'red', 'pink', 'black']

  return (
    <div className="w-screen h-full">
      <Nav />
      <Login />
    </div>
  )
}

export default App
