package com.stellarbeam.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Application context loaded");

        Student student = context.getBean("student", Student.class);
        student.test();

        // Same bean which is injected into Student bean
        Book book = context.getBean("bookBean", Book.class);
        System.out.println("Book bean is: " + book);

        context.close();
    }
}
