package main.java.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IBaseDao<T> {

    Optional<T> getEntityById(int id) throws SQLException;
    List<T> getAll();
    int insert(T entity) throws SQLException;
    int update(T entity) throws SQLException;
    void delete(T entity);
}
