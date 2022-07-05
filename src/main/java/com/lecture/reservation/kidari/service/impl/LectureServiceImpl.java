package com.lecture.reservation.kidari.service.impl;

import com.lecture.reservation.kidari.domain.Lecture;
import com.lecture.reservation.kidari.model.LectureDTO;
import com.lecture.reservation.kidari.repository.LectureRepository;
import com.lecture.reservation.kidari.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Override
    public void createLecture(LectureDTO lectureDTO) {
        Lecture savedLecture = Lecture.builder()
                .title(lectureDTO.getTitle())
                .lecturer(lectureDTO.getLecturer())
                .hall(lectureDTO.getHall())
                .content(lectureDTO.getContent())
                .numberOfAdmissions(lectureDTO.getNumberOfAdmissions())
                .startDate(LocalDateTime.now())
                .build();

        lectureRepository.save(savedLecture);
    }

    @Override
    public List<LectureDTO> getLectures() {
        List<Lecture> findAllLectures = lectureRepository.findAll();
        List<LectureDTO> responses = new ArrayList<>();

        for(Lecture lecture : findAllLectures){
            lecture.checkViewing(LocalDateTime.now());

            LectureDTO response = LectureDTO.builder()
                    .no(lecture.getNo())
                    .title(lecture.getTitle())
                    .lecturer(lecture.getLecturer())
                    .content(lecture.getContent())
                    .hall(lecture.getHall())
                    .startDate(lecture.getStartDate())
                    .numberOfAdmissions(lecture.getNumberOfAdmissions())
                    .isView(lecture.isView())
                    .build();

            // View 상태 업데이트
            lectureRepository.save(lecture);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public LectureDTO getLecture(Long no) {
        Lecture findLectureByNo = lectureRepository.findById(no).orElseThrow(() -> new NoSuchElementException("해당 강의 번호를 가진 강의를 찾을 수 없습니다."));

        return LectureDTO.builder()
                .no(findLectureByNo.getNo())
                .title(findLectureByNo.getTitle())
                .hall(findLectureByNo.getHall())
                .content(findLectureByNo.getContent())
                .lecturer(findLectureByNo.getLecturer())
                .startDate(findLectureByNo.getStartDate())
                .numberOfAdmissions(findLectureByNo.getNumberOfAdmissions())
                .isView(findLectureByNo.isView())
                .build();
    }

}
