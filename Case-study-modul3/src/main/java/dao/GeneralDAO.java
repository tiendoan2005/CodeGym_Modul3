package dao;

import model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO <E> {
    List<E> getAllMovies();
    void insertMovie(E movie) throws SQLException;
    Movie findById(int id);
    void update(E movie) throws SQLException;
    boolean delete(int id) throws SQLException;

}
