package com.hxj.mapper;

import com.hxj.domain.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public interface EmpMapper {

    public int addEmp(Emp emp);
    public int updateEmp(Emp emp);
    public int delEmp(int id);
    public Emp findEmpById(int id);


    public int findCount(HashMap condition);//ename  hiredate  sal....
    public List<Emp> findByPage(HashMap condition);//ename  hiredate  sal....      startIndex  pageCount
}
