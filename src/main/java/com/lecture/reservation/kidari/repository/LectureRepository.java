package com.lecture.reservation.kidari.repository;

import com.lecture.reservation.kidari.domain.Employee;
import com.lecture.reservation.kidari.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture ,Long> {


}
