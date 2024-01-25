package org.softrami.controller;

import jakarta.validation.Valid;
import org.softrami.controller.dto.EmployeeDTO;
import org.softrami.entities.Employee;
import org.softrami.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(this.employeeService.saveEmploye(employeeDTO), HttpStatus.CREATED);
    }
}
