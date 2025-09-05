package controller;

import dao.MovieDAO;
import model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookTicketServlet", urlPatterns = "/book-ticket")
public class BookTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieId = request.getParameter("movieId");

        MovieDAO movieDAO = new MovieDAO();
        Movie movie = movieDAO.findById(Integer.parseInt(movieId));
        request.setAttribute("movie", movie);

        LocalDate startLocal = movie.getStartDate();
        LocalDate endLocal = movie.getEndDate();

        List<String> availableDates = new ArrayList<>();
        for (LocalDate date = startLocal; !date.isAfter(endLocal); date = date.plusDays(1)) {
            availableDates.add(date.toString());
        }
        request.setAttribute("availableDates", availableDates);

        request.getRequestDispatcher("ticket/book_ticket.jsp").forward(request, response);
    }
}
