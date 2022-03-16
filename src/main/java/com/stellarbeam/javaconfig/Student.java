package com.stellarbeam.javaconfig;

public class Student {

    private Book book;
    
    // This constructor will be used to inject the dependency [book].
    // A setter for the property can also be created, to make a setter injection.
    public Student(Book book) {
        this.book = book;
    }

    public void test() {
        System.out.println("Student: I have a book " + book);

        // Moving this code to main method of App for the time being
        // StudentDAO studentDAO = new StudentDAO();
        // studentDAO.selectAllRows();
        // studentDAO.deleteRow(2);
        // studentDAO.selectAllRows();
    }
}
