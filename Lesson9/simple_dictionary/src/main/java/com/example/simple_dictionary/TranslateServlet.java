package com.example.simple_dictionary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", urlPatterns = "/translate")
public class TranslateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dict = new HashMap<String,String>();
        dict.put("red", "Màu đỏ");
        dict.put("white","Màu trắng");
        dict.put("yellow", "Màu vàng");
        dict.put("pink", "Màu hồng");
        dict.put("green", "Màu xanh lá");
        String text = request.getParameter("text");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        String result = dict.get(text);
        if(result != null) {
            out.println("Word: " + text + "<br>");
            out.println("Result: " + result + "<br>");
        }else {
            out.println("Not found");
        }
        out.println("</html>");
    }
}
