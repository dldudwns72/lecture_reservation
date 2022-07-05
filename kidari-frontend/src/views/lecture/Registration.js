import {
  CCard,
  CCardBody,
  CCardHeader,
  CRow,
  CCol,
  CCardFooter,
  CButton,
  CInputGroup,
  CInputGroupText,
} from '@coreui/react'
import React, { useEffect, useState } from 'react'
import axios from 'axios'

const Registration = () => {
  const [lectures, setLectures] = useState([])

  const apiCallData = () => {
    axios('http://localhost:8080/kidari/v1/lectures', {
      method: 'GET',
    }).then((res) => {
      setLectures(res.data)
    })
  }

  useEffect(() => {
    apiCallData()
  }, [])

  const [lectureID, setLectureID] = useState('')
  const [employeeID, setEmployeeID] = useState('')

  const onClick_Reservation = () => {
    axios(`http://localhost:8080/kidari/v1/reservations/${lectureID}/${employeeID}`, {
      method: 'POST',
    })
      .then((res) => {
        window.alert('신청에 성공하였습니다.')
      })
      .catch((err) => {
        window.alert(err.response.data.message)
      })
  }

  const onChange_employeeNumber = (e) => {
    let value = e.target.value

    setEmployeeID(value)
  }

  const onChange_lecture = (e) => {
    let value = e.target.value
    console.log(value)
    setLectureID(value)
  }

  return (
    <CCard>
      <CCardHeader>강연 신청</CCardHeader>
      <CCardBody>
        <CRow>
          <CCol lg="2">사번</CCol>
          <CCol lg="10">
            <input value={employeeID} onChange={(e) => onChange_employeeNumber(e)} />
          </CCol>
        </CRow>

        <CRow>
          <CCol lg="2">강연</CCol>
          <CCol lg="10">
            <select value={lectureID} onChange={(e) => onChange_lecture(e)}>
              <option key={''}>강의를 선택해주세요</option>
              {lectures.map((lecture, index) => {
                if (lecture.view) {
                  return (
                    <option key={index} value={lecture.no}>
                      {lecture.title}
                    </option>
                  )
                }
              })}
            </select>
          </CCol>
        </CRow>
      </CCardBody>
      <CCardFooter className="float-right">
        <CButton color="primary" onClick={() => onClick_Reservation()}>
          신청
        </CButton>
      </CCardFooter>
    </CCard>
  )
}

export default Registration
