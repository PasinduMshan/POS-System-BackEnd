package lk.ijse.possystembackend.dao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T entity) throws SQLException, NamingException;

    boolean update(T entity) throws SQLException, NamingException;

    boolean delete(String id) throws SQLException, NamingException;

    T search(String value) throws SQLException, NamingException;

    ArrayList<T> getAll() throws SQLException, NamingException;
}

