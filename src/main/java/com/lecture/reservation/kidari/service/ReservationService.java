package com.lecture.reservation.kidari.service;

import com.lecture.reservation.kidari.model.ReservationDTO;

import java.util.List;

public interface ReservationService {

    void makeReservation(Long lectureNo, Long employeeNo);

    List<ReservationDTO> getReservations();

    List<ReservationDTO> getReservationByEmployee(Long employeeID);

    List<ReservationDTO> getReservationByLecture(Long lectureId);
}
