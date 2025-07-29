package dao;

import model.User;

import java.sql.SQLException;

public interface GeneralUserDAO <E> {
    boolean register(E user) throws SQLException;
    User login(String username, String password) throws SQLException;
}
