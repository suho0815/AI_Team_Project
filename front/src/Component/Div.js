export function Div(DivclassName) {
  const className = ['box-sizing', DivclassName].join(' ')
  return <div className={className}></div>
}
