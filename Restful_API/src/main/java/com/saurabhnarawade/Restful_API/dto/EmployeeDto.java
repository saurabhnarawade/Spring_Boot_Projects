package com.saurabhnarawade.Restful_API.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeDto {


    private String empId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String department;

    private String designation;
}