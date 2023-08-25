// 전체 정보 페이지
import {Div} from '../../Component'
import {ResultBox} from './ResultBox'

export default function ResultPage() {
  // 스크롤
  //   window.addEventListener("wheel", function(e){
  //     e.preventDefault();
  // },{passive : false});

  return (
    <Div>
      <ResultBox />
    </Div>
  )
}
