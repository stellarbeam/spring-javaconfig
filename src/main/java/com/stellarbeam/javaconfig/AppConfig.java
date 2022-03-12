package com.stellarbeam.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    // "student" and "student2" are aliases for same object (one instance).
    // The [name] attribute overrides te default bean name, which is the
    // method's name ("studentBean" in this case).
    @Bean(name = {"student", "student2"})
    public Student studentBean() {

        // Gets called only once
        System.out.println(this.getClass().getSimpleName() + ": studentBean() called");
        return new Student();
    }
}
