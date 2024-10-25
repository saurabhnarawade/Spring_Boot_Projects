package com.saurabhnarawade.Restful_API.service;

import com.saurabhnarawade.Restful_API.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getByEmpId(String empId);

    void deleteEmployee(String empId);

    EmployeeDto updateEmployeeByEmpId(EmployeeDto employeeDto, String empId);
}