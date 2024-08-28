package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.custom.PlaceOrderDAO;
import lk.ijse.possystembackend.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean save(PlaceOrder entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public PlaceOrder search(String Id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<PlaceOrder> getAll() throws SQLException {
        return null;
    }
}
