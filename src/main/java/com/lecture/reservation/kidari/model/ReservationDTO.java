package com.lecture.reservation.kidari.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDTO {

    private Long no;

    private LectureDTO lecture;

    private EmployeeDTO employee;

    @Builder
    public ReservationDTO(Long no, LectureDTO lecture, EmployeeDTO employee){
        this.no = no;
        this.lecture = lecture;
        this.employee = employee;
    }

}
