package lk.ijse.possystembackend.bo.custom.impl;

import lk.ijse.possystembackend.bo.custom.ItemBO;
import lk.ijse.possystembackend.dao.DAOFactory;
import lk.ijse.possystembackend.dao.custom.ItemDAO;
import lk.ijse.possystembackend.dto.ItemDTO;
import lk.ijse.possystembackend.entity.Item;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException {
        return itemDAO.save(new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getItemUnitPrice(),
                itemDTO.getItemQty()
        ));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, NamingException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, NamingException {
        return itemDAO.update(new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getItemUnitPrice(),
                itemDTO.getItemQty()
        ));
    }

    @Override
    public List<ItemDTO> getAllItem() throws SQLException, NamingException {
        ArrayList<Item> allItems = itemDAO.getAll();

        ArrayList<ItemDTO> itemDTOs = new ArrayList<>();

        for (Item item : allItems) {
            itemDTOs.add(new ItemDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getItemUnitPrice(),
                    item.getItemQty()
            ));
        }
        return itemDTOs;
    }

    @Override
    public ItemDTO getItem(String id) throws SQLException, NamingException {
        Item item = itemDAO.search(id);

        return new ItemDTO(
                item.getItemId(),
                item.getItemName(),
                item.getItemUnitPrice(),
                item.getItemQty()
        );
    }
}
