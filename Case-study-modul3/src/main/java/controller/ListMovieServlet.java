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

        // Lấy danh sách phim từ DB qua DAO
        List<Movie> movieList = movieDAO.getAllMovies();

        // Đưa danh sách phim vào request attribute
        request.setAttribute("movieList", movieList);

        // Forward sang JSP hiển thị danh sách
        request.getRequestDispatcher("/jsp_movie/list.jsp").forward(request, response);
    }
}
