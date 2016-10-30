package com.omrani.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * Created by salim on 30/10/16.
 */
public class Triangle implements ApplicationContextAware , BeanNameAware{

//
//
//    private List<Point> points;

    private Point pointA;
    private Point pointB;
    private Point pointC;

    private ApplicationContext context = null;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }




    public void draw() {
//        for (Point point:points){
//            System.out.println("Point = {" + point.getX() + "," + point.getY() + "}");
//        }
        System.out.println("Point A = (" + getPointA().getX() +", " + getPointA().getY()+")");
        System.out.println("Point B = (" + getPointB().getX() +", " + getPointB().getY()+")");
        System.out.println("Point B = (" + getPointC().getX() +", " + getPointC().getY()+")");

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void setBeanName(String beanName) {
        System.out.println("Bean Name is :" + beanName);
    }
}
