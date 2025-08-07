package repository.custom;

import model.dto.CustomerDTO;
import repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDTO,Integer> {
}
