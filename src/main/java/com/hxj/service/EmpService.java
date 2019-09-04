package com.hxj.service;

import com.hxj.domain.Emp;
import com.hxj.mapper.EmpMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Service
public class EmpService {

    @Resource
    EmpMapper empMapper;

    @Transactional
    public boolean addEmp(Emp emp){
       return empMapper.addEmp(emp)>0;
    }

    @Transactional
    public boolean updateEmp(Emp emp){
        return empMapper.updateEmp(emp)>0;
    }

    @Transactional
    public boolean delEmp(int id){
        return empMapper.delEmp(id)>0;
    }

    @Transactional(readOnly = false)
    public Emp findEmpById(int id){
        return empMapper.findEmpById(id);
    }

    @Transactional(readOnly = false)
    public int findCount(HashMap condition){
        return empMapper.findCount(condition);
    }

    @Transactional(readOnly = false)
    public HashMap findByPage(HashMap condition){

        HashMap returnResult = new HashMap();

        //总记录数
        int totalRows = findCount(condition);
        returnResult.put("totalRows",totalRows);

        //pageCount   pageNow
        int pageNow = (Integer) condition.get("pageNow");
        int pageCount = (Integer) condition.get("pageCount");

        //总页数
        int totalPages = totalRows%pageCount==0?totalRows/pageCount:totalRows/pageCount+1;
        returnResult.put("totalPages",totalPages);

        int startIndex = (pageNow-1)*pageCount;

        condition.put("startIndex",startIndex);

        List<Emp> empList = empMapper.findByPage(condition);

        returnResult.put("empList",empList);

        return returnResult;
    }

}
