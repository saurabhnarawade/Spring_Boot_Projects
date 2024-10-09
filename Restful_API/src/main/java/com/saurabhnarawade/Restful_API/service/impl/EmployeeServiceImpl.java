package com.saurabhnarawade.Restful_API.service.impl;

import com.saurabhnarawade.Restful_API.entity.Employee;
import com.saurabhnarawade.Restful_API.exception.EmployeeWithPhoneAlreadyExists;
import com.saurabhnarawade.Restful_API.mapper.EmployeeMapper;
import com.saurabhnarawade.Restful_API.repository.EmployeeRepository;
import com.saurabhnarawade.Restful_API.dto.EmployeeDto;
import com.saurabhnarawade.Restful_API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        employeeDto.setEmpId(null);

        // Check if the email or phone already exists in the system
        employeeRepository.findByEmail(employeeDto.getEmail())
                .ifPresent( employee -> {
                    throw new EmployeeWithPhoneAlreadyExists("Employee with email " +employee.getEmail() + " already exists", 400);
                });

        employeeRepository.findByPhone(employeeDto.getPhone())
                .ifPresent(employee -> {
                    throw new EmployeeWithPhoneAlreadyExists("Employee with phone " + employee.getPhone() + " already exists", 400);
                });

        // Convert employeeDto to Employee;
        Employee employee = new Employee();

        employee = EmployeeMapper.ConvertEmployeeDtoToEmployee(employeeDto, employee);

        // Logic to generate empID
        employee.setEmpId(generateEmpId(employee.getFirstName()));
        employee.setDateOfJoining(LocalDate.now());

//        Employee savedEmployee=
        employeeRepository.save(employee);

        employeeDto.setEmpId(employee.getEmpId());
        return employeeDto;


    }

    private String generateEmpId(String firstName) {
        // Get the first two characters of the first name
        String company = "SNTECH";
        String fNameChar = firstName.substring(0, 2).toUpperCase();

        // Get the current year
        String year = String.valueOf(Year.now().getValue()).substring(2);

        // Generate a random UUID (universally unique identifier)
        String uniqueId = UUID.randomUUID().toString().substring(0, 8); // Get first 8 chars of UUID

        // Combine prefix, year, and UUID to form the unique empId
        return (company + year + fNameChar + uniqueId).toUpperCase();
    }

}