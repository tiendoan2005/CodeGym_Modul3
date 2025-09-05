package com.example.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    DBConnection dbConnection = new DBConnection();

    public void add(Employee employee) {
        //SQL INSERT INTO
        String SQL = "insert into employees (full_name, email, phone) values(?,?,?)";
        // Đảm bảo kết nối DBConnection
        Connection conn = dbConnection.getConnection();
        //PreparedStatement
        try {
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //ResultSet
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String SQL = "select * from employees";
        Connection conn = dbConnection.getConnection();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(SQL);
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
