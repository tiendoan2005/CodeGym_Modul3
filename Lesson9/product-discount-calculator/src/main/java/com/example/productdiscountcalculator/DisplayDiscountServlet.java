package com.example.productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayDiscountServlet", urlPatterns = "/display-discount")
public class DisplayDiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));


        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<h2>Discount Calculation Result</h2>");
        out.println("<p>Product Description: " + description + "</p>");
        out.println("<p>List Price: " + listPrice + "</p>");
        out.println("<p>Discount Percent: " + discountPercent + "%</p>");
        out.println("<p>Discount Amount: " + discountAmount + "</p>");
        out.println("<p>Price after Discount: " + discountPrice + "</p>");
        out.println("</html>");
    }
}
