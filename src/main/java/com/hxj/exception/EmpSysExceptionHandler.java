package com.hxj.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class EmpSysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //返回值是一个ModelAndView  如果出了异常我们就可以指定跳转的页面
        System.out.println("-------------------------------");
        System.out.println(o);
        System.out.println(e);//其他[用户看不懂的提示语句]    EmpSysException[提示语句没问题]
        System.out.println("-------------------------------");

        e.printStackTrace();

        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof EmpSysException){
            modelAndView.addObject("message",e.getMessage());
        }else{
            modelAndView.addObject("message","亲亲，不要慌，请联系管理员帮您解决问题");
        }
        modelAndView.setViewName("fail");

        return modelAndView;
    }
}
