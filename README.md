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
 1. 강연(Lecture)
  
 2. 사원(Employee)
 
 3. 예약(Reservationn)

API 로직
 Controller -> Service -> Repository -> Service -> Controller
 
Frontend 화면 소스코드 경로
 kidari-frontend/src/views/lecutre 하위 .js 파일
 클라이언트 실행 시 kidari-frontend 디렉토리 위치에서 npm start 명령어 실행


기능 구현
1. 강연 <br/>
 -1) 생성 <br/>
 -2) 전체 목록 조회 <br/> 
 &nbsp;&nbsp; -1) 수강 시작기간 -7일 +1 일 기준 목록을 보여주도록 설정, 이외 기간 목록 조회 가능여부 불가로 변경 <br/>
 -3) 강연 번호를 통한 개별 조회 <br/>
 
2. 사원 <br/>
 -1) 생성 <br/>
 &nbsp;&nbsp; -1) 사번번호 5자리로 변환하여 반환  <br/>
 -2) 전체 목록 조회 <br/>
 -3) 사번 번호를 통한 개별 조회 <br/>

3. 예약 <br/>
 -1) 예약하기 <br/>
 &nbsp;&nbsp; -1) 이미 예약한 강의일 경우 예외 발생 <br/>
 &nbsp;&nbsp; -2) 수강 인원이 가득 찼을 경우 예외 발생 <br/>
 -2) 예약 전체 목록 <br/>
 -3) 사번을통한 사번별 예약목록 <br/>
 -4) 강연 번호를 통한 강연별 예약목록 <br/>
 
