package lk.ijse.possystembackend.dao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T entity) throws SQLException, NamingException;

    boolean update(T entity) throws SQLException;

    boolean delete(String id) throws SQLException;

    T search(String Id) throws SQLException;

    ArrayList<T> getAll() throws SQLException;
}
