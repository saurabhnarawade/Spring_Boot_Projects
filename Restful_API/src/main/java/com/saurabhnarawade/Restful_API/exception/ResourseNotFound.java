package com.saurabhnarawade.Restful_API.exception;

import lombok.Getter;

@Getter
public class ResourseNotFound extends RuntimeException{

    int statusCode;
    public ResourseNotFound(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}