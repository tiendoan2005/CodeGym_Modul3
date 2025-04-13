package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            double a = Double.parseDouble(request.getParameter("num1"));
            double b = Double.parseDouble(request.getParameter("num2"));
            String operator = request.getParameter("operator");

            double result = Calculator.calculator(a, b, operator);
            out.println("<html><body>");
            out.println("<h1>Result: " + result + "</h1>");
            out.println("<a href= 'index.jsp'> Quay lại </a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h2 style='color:red;'>Lỗi: " + e.getMessage() + "</h2>");
            out.println("<a href= 'index.jsp'> Quay lại </a>");
            out.println("</body></html>");
        }finally {
            out.close();
        }
    }
}
