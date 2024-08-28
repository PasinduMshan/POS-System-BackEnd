package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.SQLUtil;
import lk.ijse.possystembackend.dao.custom.ItemDAO;
import lk.ijse.possystembackend.entity.Item;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item entity) throws SQLException, NamingException {
        return SQLUtil.execute("INSERT INTO item VALUES(?,?,?,?)", entity.getItemId(), entity.getItemName(),
                entity.getItemUnitPrice(), entity.getItemQty());
    }

    @Override
    public boolean update(Item entity) throws SQLException, NamingException {
        return SQLUtil.execute("UPDATE item SET itemName = ?, itemUnitPrice = ?, itemQty = ? WHERE itemId = ?",
                entity.getItemName(), entity.getItemUnitPrice(), entity.getItemQty(), entity.getItemId());

    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        return SQLUtil.execute("DELETE FROM item WHERE itemId = ?", id);
    }

    @Override
    public Item search(String value) throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item WHERE itemId = ?", value);
        while (resultSet.next()) {
            return new Item(
                    resultSet.getString("itemId"),
                    resultSet.getString("itemName"),
                    resultSet.getDouble("itemUnitPrice"),
                    resultSet.getDouble("itemQty")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item");

        ArrayList<Item> items = new ArrayList<>();

        while (resultSet.next()) {
            items.add(new Item(
                    resultSet.getString("itemId"),
                    resultSet.getString("itemName"),
                    resultSet.getDouble("itemUnitPrice"),
                    resultSet.getDouble("itemQty")
            ));
        }
        return items;
    }
}
