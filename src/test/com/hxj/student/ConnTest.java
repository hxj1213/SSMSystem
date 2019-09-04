package com.hxj.student;

import com.hxj.domain.Emp;
import com.hxj.mapper.EmpMapper;
import com.hxj.service.EmpService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.Date;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class ConnTest {

    @Test
    public void testConn() throws Exception{

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = factory.openSession();

        System.out.println(sqlSession);
        //org.apache.ibatis.session.defaults.DefaultSqlSession@3c756e4d

//        sqlSession.insert()
//          sqlSession.selectOne()
//        sqlSession.selectList()
//        sqlSession.update()
//        sqlSession.delete()
//        sqlSession.commit();
//        sqlSession.rollback();

        /*String s: sql语句的映射路径
        Object o:要添加的对象
        sqlSession.insert(String s,Object o)*/

        int i = sqlSession.insert("EmpMapper.addEmp",new Emp(2222,"张三丰","太极宗师",new Date(),20000));
        System.out.println("添加："+i);
        sqlSession.commit();
    }


    @Test
    public void testMapper() throws Exception {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = factory.openSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int i = mapper.addEmp(new Emp(2233,"金毛狮王","无业游民",new Date(),2000));
        System.out.println("添加："+i);
        sqlSession.commit();
    }


    @Test
    public void testSpring() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService empService = (EmpService) context.getBean("empService");
        System.out.println(empService);

        empService.addEmp(new Emp(2211,"张无忌","教主",new Date(),1000));
    }

}
