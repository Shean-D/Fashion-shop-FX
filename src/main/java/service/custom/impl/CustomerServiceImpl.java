package service.custom.impl;

import model.dto.CustomerDTO;
import model.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.CustomerRepository;
import service.custom.CustomerService;
import util.Crudutil;
import util.DaoType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = DaoFactory.getInstance().getDaoType(DaoType.CUSTOMER);
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CustomerDTO> getAllCustomers() throws SQLException {

        List<CustomerEntity> allCustomers = customerRepository.getAllCustomers();
        List<CustomerDTO> customers = new ArrayList<>();

        for (CustomerEntity customer : allCustomers) {
            customers.add(modelMapper.map(customer, CustomerDTO.class));
        }

        return customers;

    }

    @Override
    public Boolean addCustomer(CustomerDTO customer) {
        return customerRepository.save(modelMapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Boolean updateCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(Integer id) throws SQLException {

        CustomerEntity entity = customerRepository.getCustomerByid(id);
        return modelMapper.map(entity, CustomerDTO.class);


    }

    @Override
    public Boolean deleteCustomer(Integer id) {
        return null;
    }

    @Override
    public List<String> getAllCustomerIDs() throws SQLException {

        List<CustomerEntity> allCustomers = customerRepository.getAllCustomers();
        List<CustomerDTO> customers = new ArrayList<>();
        for (CustomerEntity customer : allCustomers) {
            customers.add(modelMapper.map(customer, CustomerDTO.class));
        }

        List<String> customerIDs = new ArrayList<>();
        for (CustomerDTO customer : customers) {
            customerIDs.add(String.valueOf(customer.getCustomerID()));
        }
        return customerIDs;

    }
}
