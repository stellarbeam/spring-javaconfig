package com.stellarbeam.javaconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        // The resourse used must be [AutoClosable], and the resource is auto-closed
        // after the `try` statement completes, whether normally or otherwise.
        try (Connection connection = getConnection()) {
            System.out.println("JDBC: Connection established and closed successfully");
            // TODO: Fetch all rows
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
        }

        // With the simple `try` statement, we would need the `finally` clause:
        // [Note: connection declaration must be before the `try` block in that case]
        // finally {
        //     connection.close();
        // }
    }

}
