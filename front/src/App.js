import {Login} from './Page/LoginPage/Login'
import {BrowserRouter, Routes} from 'react-router-dom'
import { FileUpload } from './Component/FileUpload'
import { SignUp } from './Page/LoginPage/SignUp'

function App() {
  // const data = [25, 45, 60, 30, 10]
  // const label = ['a', 'b', 'c', 'd', 'e']
  // const backgroundColor = ['blue', 'steelblue', 'red', 'pink', 'black']

  return (
    <div className="w-screen h-full">
      {/* <SignUp/> */}
      {/* <FileUpload/> */}
      <Login />
    </div>
  )
}

export default App
