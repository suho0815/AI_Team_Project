// Nav 바

export function Nav() {
  return (
    <div className="w-full h-[50px]">
      <div className="w-full h-[50px] absolute left-[-0.5px] top-[-0.5px] bg-transparent border border-black" />
      <p className="w-[120px] h-[50px] absolute left-[1320px] top-0 text-2xl text-center text-black">회원가입</p>
      <p className="w-[120px] h-[50px] absolute left-[1200px] top-0 text-2xl text-center text-black">로그인</p>
    </div>
  )
}
