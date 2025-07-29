package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements GeneralUserDAO<User> {
    private static final String REGISTER_USER = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    private static final String LOGIN_USER = "SELECT * FROM users WHERE username = ? AND password = ?";

    @Override
    public boolean register(User user) throws SQLException {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(REGISTER_USER)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public User login(String username, String password) throws SQLException {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(LOGIN_USER)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        }
        return null;
    }
}
