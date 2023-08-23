// 통계 관련 페이지
import {ByTime, ByType} from './ByTime'
import {Div} from '../../Component'

export default function StatisticPage() {
  return (
    <Div>
      <ByTime />
      <ByType />
    </Div>
  )
}
