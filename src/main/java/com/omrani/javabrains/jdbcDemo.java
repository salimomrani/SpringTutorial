package com.omrani.javabrains;

import com.omrani.javabrains.dao.JdbcDaoImpl;
import com.omrani.javabrains.model.Cicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by salim on 30/10/16.
 */
public class jdbcDemo {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

        System.out.println(dao.getCircleCount());
//        Cicle cicle = dao.getCircle(1);
//        System.out.println(cicle.getName());
    }

}
