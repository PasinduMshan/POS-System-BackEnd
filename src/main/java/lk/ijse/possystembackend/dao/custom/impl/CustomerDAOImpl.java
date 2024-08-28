package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.SQLUtil;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    SQLUtil sqlUtil = new SQLUtil();

    @Override
    public boolean save(Customer entity) throws SQLException, NamingException {

        try {
            return sqlUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?)", entity.getId(), entity.getName(), entity.getAddress(), entity.getTel(), entity.getNIC());

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Customer search(String Id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        return null;
    }
}
