package lk.ijse.possystembackend.bo.custom;

import lk.ijse.possystembackend.bo.SuperBO;
import lk.ijse.possystembackend.dto.CustomerDTO;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;
}
