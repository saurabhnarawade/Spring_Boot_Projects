package com.saurabhnarawade.Restful_API.exception;



public class EmployeeByEmpIdNotFound extends ResourseNotFound {


    public EmployeeByEmpIdNotFound(String message, int statusCode) {
        super(message, statusCode);
    }
}
