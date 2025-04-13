package controller;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội"));

        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
