package controller;

import dao.MovieDAO;
import model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListMovieServlet", urlPatterns = "/list")
public class ListMovieServlet extends HttpServlet {

    private MovieDAO movieDAO = new MovieDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Movie> movieList = movieDAO.getAllMovies();

        request.setAttribute("movieList", movieList);

        request.getRequestDispatcher("/jsp_movie/list.jsp").forward(request, response);
    }
}
