package com.lecture.reservation.kidari.service.impl;

import com.lecture.reservation.kidari.domain.Employee;
import com.lecture.reservation.kidari.domain.Lecture;
import com.lecture.reservation.kidari.domain.Reservation;
import com.lecture.reservation.kidari.exceptions.NotReserveException;
import com.lecture.reservation.kidari.model.EmployeeDTO;
import com.lecture.reservation.kidari.model.LectureDTO;
import com.lecture.reservation.kidari.model.ReservationDTO;
import com.lecture.reservation.kidari.repository.EmployeeRepository;
import com.lecture.reservation.kidari.repository.LectureRepository;
import com.lecture.reservation.kidari.repository.ReservationRepository;
import com.lecture.reservation.kidari.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final LectureRepository lectureRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void makeReservation(Long lectureNo, Long employeeNo) {
        Lecture lecture = lectureRepository.findById(lectureNo).orElseThrow(()-> new NoSuchElementException("해당 강의를 찾을 수 없습니다."));
        Employee employee = employeeRepository.findById(employeeNo).orElseThrow(()-> new NoSuchElementException("해당 사원을 찾을 수 없습니다."));

        for (Reservation reservation : reservationRepository.findAll()) {
            if(employeeNo == reservation.getEmployee().getIdentificationNumber()
              && lectureNo == reservation.getLecture().getNo()){
                throw new NotReserveException("이미 신청한 강의입니다.");
            }
        }

        if(lecture.checkFinishReservation()){
            lectureRepository.save(lecture);

            Reservation saveReservation = Reservation.builder()
                    .lecture(lecture)
                    .employee(employee)
                    .build();

            reservationRepository.save(saveReservation);
        }else{
            throw new NotReserveException("해당 강의 인원이 가득 찼습니다.");
        }

    }

    @Override
    public List<ReservationDTO> getReservations() {
        List<Reservation> findAll = reservationRepository.findAll();
        List<ReservationDTO> responses = new ArrayList<>();

        findAll.stream().forEach((reservation -> {
            Lecture lecture = reservation.getLecture();
            lecture.checkViewing(LocalDateTime.now());
            lecture.checkFinishReservation();

            LectureDTO lectureDTO = LectureDTO.builder()
                    .no(lecture.getNo())
                    .title(lecture.getTitle())
                    .lecturer(lecture.getLecturer())
                    .hall(lecture.getHall())
                    .content(lecture.getContent())
                    .numberOfAdmissions(lecture.getNumberOfAdmissions())
                    .isView(reservation.getLecture().isView())
                    .startDate(lecture.getStartDate())
                    .build();

            Employee employee = reservation.getEmployee();
            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                                    .identificationNumber(employee.getIdentificationNumber())
                                    .name(employee.getName())
                                        .build();

            ReservationDTO response = ReservationDTO.builder()
                    .no(reservation.getNo())
                    .lecture(lectureDTO)
                    .employee(employeeDTO)
                    .build();

            responses.add(response);
        }));

        return responses;
    }

    @Override
    public List<ReservationDTO> getReservationByEmployee(Long employeeID) {
        List<ReservationDTO> responses = new ArrayList<>();

        Employee employeeById = employeeRepository.findById(employeeID).orElseThrow(() -> new NoSuchElementException("해당 사번을 가진 사원이 존재하지 않습니다."));

        Optional<List<Reservation>> byEmployee = reservationRepository.findByEmployee(employeeById);

        List<Reservation> findByEmployee = byEmployee.orElseThrow(() -> new NoSuchElementException("해당 사원이 예약한 강연이 없습니다."));

        for(Reservation reservation : findByEmployee){
            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .identificationNumber(reservation.getEmployee().getIdentificationNumber())
                    .name(reservation.getEmployee().getName())
                    .build();

            LectureDTO lectureDTO = LectureDTO.builder()
                    .no(reservation.getLecture().getNo())
                    .title(reservation.getLecture().getTitle())
                    .lecturer(reservation.getLecture().getLecturer())
                    .hall(reservation.getLecture().getHall())
                    .content(reservation.getLecture().getContent())
                    .startDate(reservation.getLecture().getStartDate())
                    .numberOfAdmissions(reservation.getLecture().getNumberOfAdmissions())
                    .build();

            ReservationDTO response = ReservationDTO.builder()
                    .no(reservation.getNo())
                    .lecture(lectureDTO)
                    .employee(employeeDTO)
                    .build();

            responses.add(response);
        }

        return responses;
    }

    @Override
    public List<ReservationDTO> getReservationByLecture(Long lectureId) {
        List<ReservationDTO> responses = new ArrayList<>();

        Lecture lectureById = lectureRepository.findById(lectureId).orElseThrow(() -> new NoSuchElementException("해당 번호를 가진 강의이 존재하지 않습니다."));

        List<Reservation> findByLectures = reservationRepository.findByLecture(lectureById).orElseThrow(() -> new NoSuchElementException("해당 사원이 예약한 강연이 없습니다."));

        for(Reservation reservation : findByLectures){
            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .identificationNumber(reservation.getEmployee().getIdentificationNumber())
                    .name(reservation.getEmployee().getName())
                    .build();

            LectureDTO lectureDTO = LectureDTO.builder()
                    .no(reservation.getLecture().getNo())
                    .title(reservation.getLecture().getTitle())
                    .lecturer(reservation.getLecture().getLecturer())
                    .hall(reservation.getLecture().getHall())
                    .content(reservation.getLecture().getContent())
                    .startDate(reservation.getLecture().getStartDate())
                    .numberOfAdmissions(reservation.getLecture().getNumberOfAdmissions())
                    .build();

            ReservationDTO response = ReservationDTO.builder()
                    .no(reservation.getNo())
                    .lecture(lectureDTO)
                    .employee(employeeDTO)
                    .build();

            responses.add(response);
        }

        return responses;
    }
}
