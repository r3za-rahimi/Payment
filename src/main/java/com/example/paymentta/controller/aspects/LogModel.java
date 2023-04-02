package com.example.paymentta.controller.aspects;

import lombok.Data;

@Data
public class LogModel {

    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;
}
