package com.stellarbeam.javaconfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    static Logger logger = LogManager.getLogger(AppConfig.class);

    // If the @Bean annonation is present for this method, the bookBean() 
    // method gets called first, and then studentBean(). However, if absent, 
    // the order of calls is opposite. Note that, either way, both methods 
    // are called exactly once each. [Unless explicitly called again]
    @Bean
    public Book bookBean() {
        logger.debug( this.getClass().getSimpleName() + ": bookBean() called");
        return new Book();
    }
    
    // "student" and "student2" are aliases for same object (one instance).
    // The [name] attribute overrides te default bean name, which is the
    // method's name ("studentBean" in this case).
    // Default bean scope is singleton and init mode is eager. Use @Scope 
    // annotation to change scope, and @Lazy for lazy init.
    @Bean(name = {"student", "student2"})
    public Student studentBean() {

        // Gets called only once
        logger.debug( this.getClass().getSimpleName() + ": studentBean() called");

        // Even if the object returned by bookBean() is stored in temporary
        // reference variable first, the method is still called only once. 
        return new Student(bookBean());
    }

    @Bean(name = "studentDAO")
    public StudentDAO studentDAOBean() {
        // Can be obtained from .properties file
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String user = "test";
        String password = "test";

        // Since the bean scope is singleton, this object is same as that
        // injected into student bean
        logger.debug( bookBean());

        return new StudentDAO(url, user, password);
    }
}
