package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.SQLUtil;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(Customer entity) throws SQLException, NamingException {
        return SQLUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?)", entity.getId(), entity.getName(),
                entity.getAddress(), entity.getTel(), entity.getNIC());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, NamingException {
        return SQLUtil.execute("UPDATE customer SET Name = ?, Address = ?, Tel = ? , NIC = ? WHERE Id = ?", entity.getName(),
                entity.getAddress(), entity.getTel(), entity.getNIC(), entity.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        return SQLUtil.execute("DELETE FROM customer WHERE id = ?", id);
    }

    @Override
    public Customer search(String value) throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE tel = ?", value);
        while (resultSet.next()) {
            return new Customer(
                    resultSet.getString("Id"),
                    resultSet.getString("Name"),
                    resultSet.getString("Address"),
                    resultSet.getString("Tel"),
                    resultSet.getString("NIC")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer");

        ArrayList<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            customers.add(new Customer(
                    resultSet.getString("Id"),
                    resultSet.getString("Name"),
                    resultSet.getString("Address"),
                    resultSet.getString("Tel"),
                    resultSet.getString("NIC")
            ));
        }
        return customers;

    }
}
