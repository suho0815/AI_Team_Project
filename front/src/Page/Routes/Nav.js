// Nav 바
import {Link} from 'react-router-dom'

export function Nav() {
  return (
    <div className="w-full h-[50px] border border-black flex justify-end items-center">
      <Link to="/login">
        <p className="w-[120px] h-full text-2xl text-center align-middle text-black">로그인</p>
      </Link>
      <Link to="/signup">
        <p className="w-[120px] h-full text-2xl text-center align-middle text-black">회원가입</p>
      </Link>
    </div>
  )
}
