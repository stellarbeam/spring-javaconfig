package com.stellarbeam.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean("student", Student.class);
        student.test();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
