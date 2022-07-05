package com.lecture.reservation.kidari.controller;

import com.lecture.reservation.kidari.model.ReservationDTO;
import com.lecture.reservation.kidari.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("kidari/v1")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservations/{lectureNo}/{employeeNo}")
    public void makeReservation(@PathVariable Long lectureNo, @PathVariable String employeeNo){
        Long convertToLongType =  Long.parseLong(employeeNo);
        reservationService.makeReservation(lectureNo,convertToLongType);
    }

    @GetMapping("reservations")
    public List<ReservationDTO> getReservations(){
        return reservationService.getReservations();
    }

    // 사번별 강의 목록
    @GetMapping("reservation/employee/{employeeId}")
    public List<ReservationDTO> gerReservationByEmployee(@PathVariable String employeeId){
        Long convertToLongType =  Long.parseLong(employeeId);
        return reservationService.getReservationByEmployee(convertToLongType);
    }

    // 강연별 강의 목록
    @GetMapping("reservation/lecture/{lectureId}")
    public List<ReservationDTO> gerReservationByLecture(@PathVariable Long lectureId){
        return reservationService.getReservationByLecture(lectureId);
    }

}
