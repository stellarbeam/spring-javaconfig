package com.stellarbeam.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // If the @Bean annonation is present for this method, the bookBean() 
    // method gets called first, and then studentBean(). However, if absent, 
    // the order of calls is opposite. Note that, either way, both methods 
    // are called exactly once each. [Unless explicitly called again]
    @Bean
    public Book bookBean() {
        System.out.println(this.getClass().getSimpleName() + ": bookBean() called");
        return new Book();
    }
    
    // "student" and "student2" are aliases for same object (one instance).
    // The [name] attribute overrides te default bean name, which is the
    // method's name ("studentBean" in this case).
    @Bean(name = {"student", "student2"})
    public Student studentBean() {

        // Gets called only once
        System.out.println(this.getClass().getSimpleName() + ": studentBean() called");

        // Even if the object returned by bookBean() is stored in temporary
        // reference variable first, the method is still called only once. 
        return new Student(bookBean());
    }
}
