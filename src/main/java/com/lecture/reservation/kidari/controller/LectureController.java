package com.lecture.reservation.kidari.controller;

import com.lecture.reservation.kidari.model.LectureDTO;
import com.lecture.reservation.kidari.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "kidari/v1")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping(value = "/lectures")
    public void createLecture(@RequestBody LectureDTO lectureDTO){
        lectureService.createLecture(lectureDTO);
    }

    @GetMapping(value = "/lectures")
    public List<LectureDTO> getLectures(){
        return lectureService.getLectures();
    }

    @GetMapping(value = "/lectures/{no}")
    public LectureDTO getLectures(@PathVariable Long no){
        return lectureService.getLecture(no);
    }

}
