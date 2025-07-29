package dao;

import model.Ticket;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketDAO implements GeneralTicketDAO<Ticket> {
    private static final String INSERT_INTO_TICKET = "INSERT INTO tickets(user_id, movie_id, show_date) VALUES(?,?,?)";

    @Override
    public void save(Ticket ticket) throws SQLException {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_INTO_TICKET)) {
            statement.setInt(1, ticket.getUserId());
            statement.setInt(2, ticket.getMovieId());
            statement.setDate(3, new java.sql.Date(ticket.getShowDate().getTime()));

            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
