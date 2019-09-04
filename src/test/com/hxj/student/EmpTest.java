package com.hxj.student;

import com.hxj.domain.Emp;
import com.hxj.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class EmpTest {

    @Test
    public void test01() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService empService = (EmpService) context.getBean("empService");
        System.out.println(empService);

//        empService.updateEmp(new Emp(2211,"张无忌","教主",new Date(),100011));


        /*int count = empService.findCount(null);
        System.out.println(count);*/

        /*Emp emp = empService.findEmpById(7369);
        System.out.println(emp);*/


        HashMap hashMap = new HashMap();
        hashMap.put("pageNow",1);
        hashMap.put("pageCount",10);
        hashMap.put("ename","张");
        HashMap re = empService.findByPage(hashMap);
        System.out.println(re);
    }

}
