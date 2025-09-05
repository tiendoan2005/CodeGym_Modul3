package com.example.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/employee?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "123456789A";

    public static Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database successfully");
        }catch (SQLException e) {
            //e.printStackTrace();
            System.out.print("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
