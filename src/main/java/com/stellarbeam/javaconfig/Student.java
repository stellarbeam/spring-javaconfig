package com.stellarbeam.javaconfig;

public class Student {

    private Book book;
    
    // This constructor will be used to inject the dependency [book].
    // A setter for the property can also be created, to make a setter injection.
    public Student(Book book) {
        this.book = book;
    }

    public void test() {
        System.out.println("Hi, I'm a student");
        System.out.println("I have a book: " + book);
    }
}
