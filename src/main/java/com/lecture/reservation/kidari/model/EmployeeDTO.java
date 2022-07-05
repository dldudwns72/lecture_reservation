package com.lecture.reservation.kidari.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeDTO {

    private String identificationNumber;
    private String name;

    @Builder
    public EmployeeDTO(long identificationNumber, String name){
        this.identificationNumber = String.format("%05d",identificationNumber);
        this.name = name;
    }

}
