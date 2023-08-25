<<<<<<< Updated upstream
import {RouteMain} from './Page/Routes/RouteMain'
=======
import {Login} from './Page/LoginPage/Login'
import {Nav} from './Page/Nav'
import {BrowserRouter, Routes} from 'react-router-dom'
import { FileUpload } from './Component/FileUpload'
>>>>>>> Stashed changes

function App() {
  // const data = [25, 45, 60, 30, 10]
  // const label = ['a', 'b', 'c', 'd', 'e']
  // const backgroundColor = ['blue', 'steelblue', 'red', 'pink', 'black']

  return (
<<<<<<< Updated upstream
    <div className="w-full h-screen">
      <RouteMain />
=======
    <div className="w-screen h-full">
      <Nav />
      <FileUpload/>
      {/* <Login /> */}
>>>>>>> Stashed changes
    </div>
  )
}

export default App
