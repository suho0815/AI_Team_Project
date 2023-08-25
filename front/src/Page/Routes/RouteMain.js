import {Routes, Route, BrowserRouter} from 'react-router-dom'
import {Nav} from './Nav'
import {Login} from '../LoginPage/Login'
import {SignUp} from '../LoginPage/SignUp'
import MainPage from '../MainPage'
import ResultPage from '../ResultPage'
import StatisticPage from '../StatisticPage'

export function RouteMain() {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/result" element={<ResultPage />} />
        <Route path="/static" element={<StatisticPage />} />
      </Routes>
    </BrowserRouter>
  )
}
