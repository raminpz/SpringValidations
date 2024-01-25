package org.softrami.service;

import org.softrami.controller.dto.EmployeeDTO;
import org.softrami.entities.Department;
import org.softrami.entities.Employee;
import org.softrami.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmploye(EmployeeDTO employeeDTO){
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .height(employeeDTO.getHeight())
                .married(employeeDTO.isMarried())
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .age(employeeDTO.getAge())
                .department(Department.builder()
                        .name(employeeDTO.getDepartmentDTO().getName())
                        .city(employeeDTO.getDepartmentDTO().getCity())
                        .build())
                .build();
        return employeeRepository.save(employee);
    }
}
