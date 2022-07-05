package com.lecture.reservation.kidari.controller;

import com.lecture.reservation.kidari.model.EmployeeDTO;
import com.lecture.reservation.kidari.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "kidari/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeDTO employee){
        employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeNo}")
    public EmployeeDTO getEmployee(@PathVariable Long employeeNo){
        return employeeService.getEmployees(employeeNo);
    }


}
