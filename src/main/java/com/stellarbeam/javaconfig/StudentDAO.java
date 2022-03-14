package com.stellarbeam.javaconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StudentDAO {

    // => Deprecated class
    // private String driverClass = "com.mysql.jdbc.Driver";
    // => New class
    // private String driverClass = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://127.0.0.1:3306/students";
    private String user = "test";
    private String password = "test";

    private Connection getConnection() throws SQLException {

        // For older JDK versions, we had to manually load driver class
        // It then gets automatically registered with driver manager
        // Class.forName(driverClass);
        
        // Works with newer JDK versions (I am using OpenJDK 11 installation
        // at the moment, but I've set maven settings to use {Open}JDK 8)
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        return DriverManager.getConnection(url, user, password);
    }

    public void selectAllRows() {

        // This is a `try-with-resources` statement.
        // The resourses used must be [AutoClosable], and the resources are auto-closed
        // after the `try` statement completes, whether normally or otherwise.
        // The resources declared become read-only.
        try (
            Connection connection = getConnection(); 
            Statement statement = connection.createStatement()
        ) {
            System.out.println("JDBC: Connection established and closed successfully");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentInfo");

            while(resultSet.next()) {
                int studentId = resultSet.getInt(1);
                String lastName = resultSet.getString(2);
                String firstName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String city = resultSet.getString(5);

                System.out.println("StudentID: " + studentId + " | LastName: " + lastName + 
                    " | FirstName: " + firstName + " | Address: " + address + " | City: " + city);
            }
            
        } catch (SQLException e) {
            System.out.println("JDBC: Error connecting to database");
        }

        // With the simple `try` statement, we would need the `finally` clause:
        // [Note: connection declaration must be before the `try` block in that case]
        // finally {
        //     connection.close();
        // }
    }

}
