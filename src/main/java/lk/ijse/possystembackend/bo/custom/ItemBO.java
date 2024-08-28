package lk.ijse.possystembackend.bo.custom;

import lk.ijse.possystembackend.bo.SuperBO;
import lk.ijse.possystembackend.dto.ItemDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException;

    boolean deleteItem(String id) throws SQLException, NamingException;

    boolean updateItem(ItemDTO itemDTO) throws SQLException, NamingException;

    List<ItemDTO> getAllItem() throws SQLException, NamingException;

    ItemDTO getItem(String id) throws SQLException, NamingException;
}
