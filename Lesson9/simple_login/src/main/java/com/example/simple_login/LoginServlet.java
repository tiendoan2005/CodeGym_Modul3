package com.example.simple_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số username và password từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // In ra các giá trị để kiểm tra (debugging)
        System.out.println("Received username: " + username);
        System.out.println("Received password: " + password);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        // Kiểm tra username và password
        if ("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome " + username + " to the website</h1>");
        } else {
            writer.println("<h1>Login Error: Incorrect username or password</h1>");
        }

        writer.println("</html>");
    }
}
