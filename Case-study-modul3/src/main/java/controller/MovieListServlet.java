package controller;

import dao.MovieDAO;
import model.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns = "/movies")
public class MovieListServlet extends HttpServlet {
    private MovieDAO movieDAO;

    @Override
    public void init() {
        movieDAO = new MovieDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    showCreateForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    showDeleteMovie(req, resp);
                    break;
                default:
                    listMovies(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    insertMovie(req, resp);
                    break;
                case "edit":
                    updateMovie(req, resp);
                    break;
                case "delete":
                    deleteMovieConfirmed(req, resp);
                case "find":
                    findMovie(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listMovies(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Movie> movieList = movieDAO.getAllMovies();
        req.setAttribute("movieList", movieList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_movie/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_movie/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertMovie(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String description = req.getParameter("description");
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        Movie movie = new Movie(title, genre, duration, description, startDate, endDate);
        movieDAO.insertMovie(movie);
        resp.sendRedirect("movies");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Movie movie = movieDAO.findById(id);
        req.setAttribute("movie", movie);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_movie/edit.jsp");
        dispatcher.forward(req, resp);
    }


    private void updateMovie(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String description = req.getParameter("description");
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        Movie movie = new Movie(id, title, genre, duration, description, startDate, endDate);
        movieDAO.update(movie);
        resp.sendRedirect("movies");
    }

    private void showDeleteMovie(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Movie> movieList = movieDAO.getAllMovies();
        req.setAttribute("movieList", movieList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_movie/delete.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteMovieConfirmed(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        movieDAO.delete(id);
        resp.sendRedirect("movies");
    }

    private void findMovie(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String keyword = req.getParameter("keyword");
        List<Movie> result = movieDAO.findByTitle(keyword);
        if (result.isEmpty()) {
            req.setAttribute("message", "Không có phim trùng từ khóa: " + keyword);
        }else{
            req.setAttribute("movieList", result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_movie/list.jsp");
        dispatcher.forward(req, resp);
    }
}
