package com.lecture.reservation.kidari.service;

import com.lecture.reservation.kidari.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getEmployees();

    EmployeeDTO getEmployees(Long no);


}
