package com.lecture.reservation.kidari;

import com.lecture.reservation.kidari.domain.Employee;
import com.lecture.reservation.kidari.domain.Lecture;
import com.lecture.reservation.kidari.domain.Reservation;
import com.lecture.reservation.kidari.model.EmployeeDTO;
import com.lecture.reservation.kidari.model.LectureDTO;
import com.lecture.reservation.kidari.repository.EmployeeRepository;
import com.lecture.reservation.kidari.repository.LectureRepository;
import com.lecture.reservation.kidari.repository.ReservationRepository;
import com.lecture.reservation.kidari.service.EmployeeService;
import com.lecture.reservation.kidari.service.LectureService;
import com.lecture.reservation.kidari.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class KidariApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidariApplication.class, args);
	}

	private final LectureRepository lectureRepository;
	private final EmployeeRepository employeeRepository;
	private final ReservationService reservationService;

	@PostConstruct
	public void init(){
		Lecture LiteratureLecture = Lecture.builder()
				.title("문학 강연")
				.lecturer("홍길동")
				.hall("3강연장")
				.content("문학에 대한 전반적인 이해")
				.numberOfAdmissions(10)
				.startDate(LocalDateTime.of(2022,7,4,15,30))
				.build();

		Lecture MathLecture = Lecture.builder()
				.title("수학 강연")
				.lecturer("김수학")
				.hall("키다리홀")
				.content("수학이란 무엇인가")
				.numberOfAdmissions(5)
				.startDate(LocalDateTime.of(2022,6,10,15,30))
				.build();

		Lecture BeautyLecture = Lecture.builder()
				.title("미용 강연")
				.lecturer("이뷰티")
				.hall("중앙홀")
				.content("뷰티의 강연")
				.numberOfAdmissions(5)
				.startDate(LocalDateTime.of(2022,7,5,15,30))
				.build();

		lectureRepository.save(LiteratureLecture);
		lectureRepository.save(MathLecture);
		lectureRepository.save(BeautyLecture);

		Employee employeeEntity = Employee.builder()
				.name("이영준")
				.build();

		employeeRepository.save(employeeEntity);

		reservationService.makeReservation(LiteratureLecture.getNo(),employeeEntity.getIdentificationNumber());
	}
}
