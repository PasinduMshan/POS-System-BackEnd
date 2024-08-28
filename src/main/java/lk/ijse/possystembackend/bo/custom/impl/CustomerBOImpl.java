package lk.ijse.possystembackend.bo.custom.impl;

import lk.ijse.possystembackend.bo.custom.CustomerBO;
import lk.ijse.possystembackend.dao.DAOFactory;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean deleteCustomer(String id) throws SQLException, NamingException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDAO.update(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel(),
                customerDTO.getNic()
        ));
    }

    @Override
    public CustomerDTO getCustomer(String tel) throws SQLException, NamingException {
        Customer customer = customerDAO.search(tel);

        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getTel(),
                customer.getNIC()
        );
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws SQLException, NamingException {
        ArrayList<Customer> allCustomers = customerDAO.getAll();

        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : allCustomers) {
            customerDTOs.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getTel(),
                    customer.getNIC()
            ));
        }
        return customerDTOs;
    }


}
