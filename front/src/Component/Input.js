export const Input = ({type, className, placeholder, name, id, onChange}) => {
  const inputClassName = ['input', 'w-2/3', 'border', className].join(' ')
  return (
    <input type={type} id={id} name={name} placeholder={placeholder} className={inputClassName} onChange={onChange} />
  )
}

export const LoginInput = ({label, type, placeholder, onChange}) => {
  return (
    <div>
      <label htmlFor={type} className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
        {label}
      </label>
      <input
        type={type}
        name={type}
        id={type}
        className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        placeholder={placeholder}
        required=""
        onChange={onChange}
      />
    </div>
  )
}
