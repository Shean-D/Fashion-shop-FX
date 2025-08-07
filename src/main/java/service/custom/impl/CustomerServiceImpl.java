package service.custom.impl;

import model.dto.CustomerDTO;
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

    @Override
    public List<CustomerDTO> getAllCustomers() throws SQLException {

        ResultSet resultSet = Crudutil.execute("select * from customer");
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        while (resultSet.next()) {
            customers.add(new CustomerDTO(
               resultSet.getInt("id"),
               resultSet.getString("name"),
               resultSet.getString("address"),
               resultSet.getString("contact"),
               resultSet.getString("email")
            ));
        }
        return customers;

    }

    @Override
    public Boolean addCustomer(CustomerDTO customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean updateCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(Integer id) throws SQLException {
        ResultSet resultSet = Crudutil.execute("select * from customer where id=?",id);
        if(resultSet.next()){
            return new CustomerDTO(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("contact"),
                    resultSet.getString("email")
            );
        }
        return null;
    }

    @Override
    public Boolean deleteCustomer(Integer id) {
        return null;
    }

    @Override
    public List<String> getAllCustomerIDs() throws SQLException {
        List<CustomerDTO> all = getAllCustomers();
        ArrayList<String> customerIDList = new ArrayList<>();
        all.forEach(customer -> {
            customerIDList.add(String.valueOf(customer.getCustomerID()));
        });
        return customerIDList;
    }
}
