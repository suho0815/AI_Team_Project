export const Icon = ({name, _className, style}) => {
  const iconClassName = ['material-icons', _className].join(' ')
  return (
    <span className={iconClassName} style={style}>
      {name}
    </span>
  )
}
