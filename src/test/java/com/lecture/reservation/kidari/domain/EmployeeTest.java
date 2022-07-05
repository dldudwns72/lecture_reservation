package com.lecture.reservation.kidari.domain;

import com.lecture.reservation.kidari.model.EmployeeDTO;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeTest {

    EmployeeDTO employee1 = EmployeeDTO.builder()
            .identificationNumber(1)
            .name("이영준")
            .build();

    EmployeeDTO employee2 = EmployeeDTO.builder()
            .identificationNumber(2)
            .name("홍길동")
            .build();

    @Test
    void createEmployee(){
         assertThat(employee1.getIdentificationNumber()).isEqualTo("00001");
         assertThat(employee1.getName()).isEqualTo("이영준");

        assertThat(employee2.getIdentificationNumber()).isEqualTo("00002");
        assertThat(employee2.getName()).isEqualTo("홍길동");
    }


}
