package com.stellarbeam.javaconfig;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.debug( "Application context loaded");

        Student student = context.getBean("student", Student.class);
        student.test();

        // Same bean which is injected into Student bean
        Book book = context.getBean("bookBean", Book.class);
        logger.debug( "Book bean is: " + book);

        StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
        studentDAO.selectAllRows();
        studentDAO.deleteRow(2);
        studentDAO.selectAllRows();

        context.close();

        // Closes context on JVM shutdown, unless already closed
        // Can be used instead of .close()
        // context.registerShutdownHook();
    }
}
