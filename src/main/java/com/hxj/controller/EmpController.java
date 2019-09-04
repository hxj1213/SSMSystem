package com.hxj.controller;

import com.hxj.domain.Emp;
import com.hxj.exception.EmpSysException;
import com.hxj.page.PageBean;
import com.hxj.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Resource
    EmpService empService;

    @RequestMapping("/add")
    public String  add(Emp emp){
        boolean flag = empService.addEmp(emp);
        if (flag) {
            return "success";
        } else {
            return "fail";
        }
    }

   /* @RequestMapping("/add")
    public String  add(Emp emp) throws Exception{
        try {
            boolean flag = empService.addEmp(emp);
            if (flag) {
                return "success";
            } else {
                return "fail";
            }
        }catch (Exception e){
            throw new EmpSysException("添加没有成功，因为一点点内部错误");
        }
    }*/

    @RequestMapping("/update")
    public String update(Emp emp) throws Exception{
        try {
            boolean flag = empService.updateEmp(emp);
            if (flag) {
                return "success";
            } else {
                return "fail";
            }
        }catch (Exception e){
            throw new EmpSysException("修改没有成功，因为一点点内部错误");
        }

    }

    @RequestMapping("/del")
    public String  del(int empno) throws Exception{
        try {
            boolean flag = empService.delEmp(empno);
            if (flag) {
                return "success";
            } else {
                return "fail";
            }
        }catch (Exception e){
            throw new EmpSysException("删除没有成功，因为一点点内部错误");
        }
    }


    @RequestMapping("/findById")
    public ModelAndView  findById(int empno) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findById");
        try {
            Emp emp = empService.findEmpById(empno);
            modelAndView.addObject("emp",emp);
            return modelAndView;
        }catch (Exception e){
            throw new EmpSysException("查询没有成功，因为一点点内部错误");
        }
    }


    @RequestMapping("/findByPage")
    public ModelAndView  findByPage(PageBean<Emp> empPageBean) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("emplist");

        HashMap hashMap = empPageBean.getCondition();
        hashMap.put("pageNow",empPageBean.getPageNow());
        hashMap.put("pageCount",empPageBean.getPageCount());
        try {
            HashMap empdata = empService.findByPage(hashMap);
            modelAndView.addObject("empdata",empdata);
            return modelAndView;
        }catch (Exception e){
            throw new EmpSysException("查询没有成功，因为一点点内部错误");
        }
    }


    @RequestMapping("/findByJson")
    public @ResponseBody
    HashMap  findByJson(@RequestBody HashMap condition) throws Exception{
        try {
            HashMap empdata = empService.findByPage(condition);
            return empdata;
        }catch (Exception e){
            throw new EmpSysException("查询没有成功，因为一点点内部错误");
        }
    }

}
