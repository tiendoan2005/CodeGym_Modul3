package dao;

import java.sql.SQLException;

public interface GeneralTicketDAO<E> {
    void save(E e) throws SQLException;
}
