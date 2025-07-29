package controller;

import dao.TicketDAO;
import model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ConfirmBookingServlet", urlPatterns = "/confirm-booking")
public class ConfirmBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int userId = Integer.parseInt(request.getParameter("userId"));
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            String showDateStr = request.getParameter("showDate");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date showDate = formatter.parse(showDateStr);
            Ticket ticket = new Ticket(userId, movieId, showDate);

            TicketDAO ticketDAO = new TicketDAO();
            ticketDAO.save(ticket);

            request.setAttribute("message", "Đặt vé thành công!");
            request.getRequestDispatcher("ticket/booking_success.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("ticket/book_ticket.jsp").forward(request, response);
        }
    }
}
