사용한 개발 언어
1. Backend
  -  JAVA 11
 
2. Frontend
  - React.js
  
사용한 프레임워크
 - Spring Boot, JPA
 
사용한 RDBMS
 - H2

데이타 설계
 - 사원 1 : 예약 N : 강의 1
 
기타 설명
 - 3개의 도메인으로 나누어서 강연 예약 시스템을 구현하였습니다.
 1. 강의(Lecture)
 
 2. 사원(Employee)
 
 3. 예약(Reservationn)

API 로직
 Controller -> Service -> Repository -> Service -> Controller
