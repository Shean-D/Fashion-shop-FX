package repository.custom;

import model.dto.CustomerDTO;
import model.entity.CustomerEntity;
import repository.CrudRepository;
import repository.SuperDao;

import java.util.List;

public interface CustomerRepository extends SuperDao {

    CustomerEntity getCustomerByid(Integer id);

    Boolean save(CustomerEntity entity);

    Boolean update(CustomerEntity entity);

    Boolean delete(CustomerEntity entity);

    List<CustomerEntity> getAllCustomers();

}
