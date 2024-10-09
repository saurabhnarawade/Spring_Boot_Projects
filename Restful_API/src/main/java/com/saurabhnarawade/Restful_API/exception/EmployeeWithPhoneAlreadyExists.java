package com.saurabhnarawade.Restful_API.exception;

public class EmployeeWithPhoneAlreadyExists extends ResourseNotFound {

    public EmployeeWithPhoneAlreadyExists(String message, int statusCode) {
        super(message, statusCode);
    }
}