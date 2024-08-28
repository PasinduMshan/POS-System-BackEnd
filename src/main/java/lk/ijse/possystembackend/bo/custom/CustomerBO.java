package lk.ijse.possystembackend.bo.custom;

import lk.ijse.possystembackend.bo.SuperBO;
import lk.ijse.possystembackend.dto.CustomerDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;

    boolean deleteCustomer(String id) throws SQLException, NamingException;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;

    CustomerDTO getCustomer(String tel) throws SQLException, NamingException;

    List<CustomerDTO> getAllCustomers() throws SQLException, NamingException;

}
