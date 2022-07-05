package com.lecture.reservation.kidari.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "identification_number")
    private Long identificationNumber;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    private List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Employee(String name){
        this.name = name;
    }


}
