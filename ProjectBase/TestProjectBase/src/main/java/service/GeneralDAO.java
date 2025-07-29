package service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO <E>{
    List<E> findAll();
    List<E> findAllWithStoreProcedure();
    void save(E entity) throws SQLException;
    void saveWithStoreProcedure(E entity) throws SQLException;
    public E findById(int id);
    public boolean update(E entity) throws SQLException;
    public E findByIdWithStoreProcedure(int id);
    public boolean updateWithStoreProcedure(E entity) throws SQLException;
}

