package com.saurabhnarawade.Restful_API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> {

    private String statusCode;

//    private String statusMessage;
    private T data;


}