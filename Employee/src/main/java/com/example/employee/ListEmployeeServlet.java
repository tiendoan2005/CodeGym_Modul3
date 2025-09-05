package com.example.employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list-employee")
public class ListEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAll();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("WEB-INF/list-employee.jsp").forward(req, resp);
    }
}
