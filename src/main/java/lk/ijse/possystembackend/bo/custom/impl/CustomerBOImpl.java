package lk.ijse.possystembackend.bo.custom.impl;

import lk.ijse.possystembackend.bo.custom.CustomerBO;
import lk.ijse.possystembackend.dao.DAOFactory;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDAO.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel(),
                customerDTO.getNic()
        ));
    }
}
