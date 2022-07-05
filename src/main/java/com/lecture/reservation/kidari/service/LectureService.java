package com.lecture.reservation.kidari.service;

import com.lecture.reservation.kidari.model.LectureDTO;

import java.util.List;

public interface LectureService {

    void createLecture(LectureDTO lectureDTO);

    List<LectureDTO> getLectures();

    LectureDTO getLecture(Long no);

}
