package com.lecture.reservation.kidari.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@NoArgsConstructor
public class LectureDTO {

    private Long no;

    private String title;

    private String lecturer;

    private String hall;

    private String content;

    private int numberOfAdmissions;

    private LocalDateTime startDate;

    private boolean isView = false;

    private boolean ableReservation = true;

    @Builder
    public LectureDTO(Long no, String title, String lecturer, String hall, String content,
                      int numberOfAdmissions,LocalDateTime startDate, boolean isView){
        this.no = no;
        this.title = title;
        this.lecturer = lecturer;
        this.hall = hall;
        this.content = content;
        this.numberOfAdmissions = numberOfAdmissions;
        this.startDate = startDate;
        this.isView = isView;
    }


}
