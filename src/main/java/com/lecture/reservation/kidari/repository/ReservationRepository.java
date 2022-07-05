package com.lecture.reservation.kidari.repository;

import com.lecture.reservation.kidari.domain.Employee;
import com.lecture.reservation.kidari.domain.Lecture;
import com.lecture.reservation.kidari.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Optional<List<Reservation>> findByEmployee(Employee employee);

    Optional<List<Reservation>> findByLecture(Lecture lecture);


}
