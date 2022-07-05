package com.lecture.reservation.kidari.service.impl;

import com.lecture.reservation.kidari.domain.Employee;
import com.lecture.reservation.kidari.model.EmployeeDTO;
import com.lecture.reservation.kidari.repository.EmployeeRepository;
import com.lecture.reservation.kidari.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee saveEmployee = Employee.builder()
                .name(employeeDTO.getName())
                .build();

        employeeRepository.save(saveEmployee);
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> responses = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            EmployeeDTO response = EmployeeDTO.builder()
                    .identificationNumber(employee.getIdentificationNumber())
                    .name(employee.getName())
                    .build();

            responses.add(response);
        }

        return responses;
    }

    @Override
    public EmployeeDTO getEmployees(Long no) {
        Employee employee = employeeRepository.findById(no).orElseThrow(() -> new NoSuchElementException("해당 사번을 가진 직원을 찾을 수 없습니다."));
        EmployeeDTO response =  EmployeeDTO.builder()
                .identificationNumber(employee.getIdentificationNumber())
                .name(employee.getName())
                .build();

        return response;
    }
}
