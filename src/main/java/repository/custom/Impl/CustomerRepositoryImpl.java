package repository.custom.Impl;

import model.dto.CustomerDTO;
import repository.custom.CustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Boolean save(CustomerDTO entity) {
        return null;
    }

    @Override
    public Boolean update(CustomerDTO entity) {
        return null;
    }

    @Override
    public CustomerDTO search(Integer integer) {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return List.of();
    }
}
