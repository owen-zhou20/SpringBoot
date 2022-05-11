package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//springMVC Exception Handler
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //get all exception
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){

        //record log
        //notice maintenance
        //notice developer
        ex.printStackTrace();
        return new R(false,"server error, Please notice maintenance");
    }

}
