package com.lecture.reservation.kidari.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "lecture_no")
    private Long no;

    @Column
    private String title;

    @Column
    private String lecturer;

    @Column
    private String hall;

    @Column
    private String content;

    @Column
    private int numberOfAdmissions;

    @Column
    private LocalDateTime startDate;

    @Column
    private boolean isView = false;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lecture")
    private List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Lecture(String title, String lecturer, String hall, String content,int numberOfAdmissions,LocalDateTime startDate){
     this.title= title;
     this.lecturer = lecturer;
     this.hall =hall;
     this.content  = content;
     this.numberOfAdmissions = numberOfAdmissions;
     this.startDate = startDate;
    }

    public boolean checkFinishReservation(){
        boolean ableReservation = true;
        if(numberOfAdmissions == 0){
            ableReservation = false;
        }

        if(numberOfAdmissions != 0){
            numberOfAdmissions--;
        }

        return ableReservation;
    }

    public void checkViewing(LocalDateTime datetime){
        long betweenDays = Duration.between(startDate,datetime).toDays();

        if(betweenDays >-1 &&  betweenDays <= 7 ){
            isView = true;
        }

        if(betweenDays < -1 && betweenDays > 7){
            isView = false;
        }
    }

}
