import React, { useEffect, useState } from 'react'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CTable,
  CTableBody,
  CTableCaption,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
} from '@coreui/react'

import axios from 'axios'

const List = () => {
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
  return (
    <CCard>
      <CCardHeader>강연목록</CCardHeader>
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
            {lectures.map((lecture) => {
              if (lecture.view) {
                return (
                  <>
                    <CTableRow>
                      <CTableDataCell>{lecture.title}</CTableDataCell>
                      <CTableDataCell>{lecture.lecturer}</CTableDataCell>
                      <CTableDataCell>{lecture.hall}</CTableDataCell>
                      <CTableDataCell>{lecture.numberOfAdmissions}</CTableDataCell>
                      <CTableDataCell>{lecture.startDate}</CTableDataCell>
                    </CTableRow>
                  </>
                )
              }
            })}
          </CTableBody>
        </CTable>
      </CCardBody>
    </CCard>
  )
}

export default List
