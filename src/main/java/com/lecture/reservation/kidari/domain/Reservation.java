package com.lecture.reservation.kidari.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "reservation_no")
    private Long no;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no")
    private Lecture lecture;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identificationNumber")
    private Employee employee;

    @Builder
    public Reservation(Lecture lecture,Employee employee){
        this.lecture = lecture;
        this.employee = employee;
    }

}
