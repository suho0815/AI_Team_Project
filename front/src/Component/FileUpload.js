import {Div} from './Div'
import {Icon} from './Icon'
import React, {useState, useRef, useEffect} from 'react'

export const FileUpload = () => {
  const fileRef = useRef()
  const [fileName, setFileName] = useState('')

  // 업로드 버튼 클릭 시 DB에 import
  const UploadBtnClicked = () => {
    const fileName = fileRef.current?.files[0]?.name
    console.log(fileName)
  }

  // 파일 선택 시 파일 이름 가져오기
  const handleFileChange = () => {
    if (fileRef.current.files.length > 0) {
      const selectedFileName = fileRef.current.files[0].name
      setFileName(selectedFileName)
    } else {
      setFileName('')
    }
  }

  return (
    <Div className="w-full">
      <label htmlFor="file" className="flex justify-between w-4/5 p-4 m-auto border border-gray-200">
        {fileName ? fileName : '파일 찾기'}
        <Icon name="file_open" />
      </label>
      <input type="file" id="file" ref={fileRef} className="hidden" onChange={handleFileChange} />
      <Div className="flex justify-end mt-4 mr-4">
        <button className="text-white btn btn-info" onClick={UploadBtnClicked}>
          업로드
        </button>
      </Div>
    </Div>
  )
}
