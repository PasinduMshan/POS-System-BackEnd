package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.custom.ItemDAO;
import lk.ijse.possystembackend.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Item entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Item search(String Id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException {
        return null;
    }
}
