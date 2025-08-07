package service.custom;

import model.dto.CustomerDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService extends SuperService {

    List<CustomerDTO> getAllCustomers() throws SQLException;

    Boolean addCustomer(CustomerDTO customer);

    Boolean updateCustomer(CustomerDTO customer);

    CustomerDTO findCustomerById(Integer id) throws SQLException;

    Boolean deleteCustomer(Integer id);

    List<String> getAllCustomerIDs() throws SQLException;
}
