package com.stellarbeam.javaconfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Student {

    static Logger logger = LogManager.getLogger(Student.class);

    private Book book;
    
    // This constructor will be used to inject the dependency [book].
    // A setter for the property can also be created, to make a setter injection.
    public Student(Book book) {
        this.book = book;
    }

    public void test() {
        logger.debug("Student: I have a book " + book);

        // Moving this code to main method of App for the time being
        // StudentDAO studentDAO = new StudentDAO();
        // studentDAO.selectAllRows();
        // studentDAO.deleteRow(2);
        // studentDAO.selectAllRows();
    }
}
