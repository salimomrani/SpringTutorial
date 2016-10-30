package com.omrani.javabrains;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by salim on 30/10/16.
 */
public class DrawingApp {


    public static void main(String[] args){


        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");
        Triangle triangle = (Triangle) context.getBean("triangle1");
        triangle.draw();
    }
}
