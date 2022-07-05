import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CTable,
  CTableBody,
  CButton,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
} from '@coreui/react'
import React, { useState } from 'react'
import axios from 'axios'

const ApplicationInquiry = () => {
  const [employeeNumber, setEmployeeNumber] = useState('')
  const [reservedLectures, setReservedLectures] = useState([])

  const onChange_changeEmployeeNumber = (e) => {
    let value = e.target.value

    setEmployeeNumber(value)
  }

  const apiCallData = () => {
    axios(`http://localhost:8080/kidari/v1/reservation/employee/${employeeNumber}`, {
      method: 'GET',
    })
      .then((res) => {
        setReservedLectures(res.data)
      })
      .catch((err) => {
        setReservedLectures([])
      })
  }

  const onClick_searchReservedLecture = () => {
    apiCallData()
  }

  return (
    <>
      <CCard>
        <CCardHeader>강연 조회</CCardHeader>
        <CCardBody>
          <CRow>
            <CCol lg="2" className="mt-1">
              사번
            </CCol>
            <CCol lg="2" className="mt-1">
              <input value={employeeNumber} onChange={(e) => onChange_changeEmployeeNumber(e)} />
            </CCol>
            <CCol lg="2" className="mt-1">
              <CButton color="primary" size="sm" onClick={() => onClick_searchReservedLecture()}>
                조회
              </CButton>
            </CCol>
            <CCol lg="6"></CCol>
          </CRow>
        </CCardBody>
      </CCard>

      <hr />

      <CCard>
        <CCardHeader>예약된 목록</CCardHeader>
        <CCardBody>
          <CTable>
            <CTableHead>
              <CTableRow>
                <CTableHeaderCell scope="col">강연명</CTableHeaderCell>
                <CTableHeaderCell scope="col">강연자</CTableHeaderCell>
                <CTableHeaderCell scope="col">강연장</CTableHeaderCell>
                <CTableHeaderCell scope="col">신청가능인원</CTableHeaderCell>
                <CTableHeaderCell scope="col">강연시간</CTableHeaderCell>
              </CTableRow>
            </CTableHead>
            <CTableBody>
              {reservedLectures.map((reservation) => {
                return (
                  <>
                    <CTableRow>
                      <CTableDataCell>{reservation.lecture.title}</CTableDataCell>
                      <CTableDataCell>{reservation.lecture.lecturer}</CTableDataCell>
                      <CTableDataCell>{reservation.lecture.hall}</CTableDataCell>
                      <CTableDataCell>{reservation.lecture.numberOfAdmissions}</CTableDataCell>
                      <CTableDataCell>{reservation.lecture.startDate}</CTableDataCell>
                    </CTableRow>
                  </>
                )
              })}
            </CTableBody>
          </CTable>
        </CCardBody>
      </CCard>
    </>
  )
}

export default ApplicationInquiry
