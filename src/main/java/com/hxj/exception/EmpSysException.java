package com.hxj.exception;

import org.springframework.web.servlet.ModelAndView;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class EmpSysException extends Exception{

    private String message;

    public EmpSysException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
