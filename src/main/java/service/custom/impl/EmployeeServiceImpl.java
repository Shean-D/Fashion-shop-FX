package service.custom.impl;

import model.dto.EmployeeDTO;
import service.custom.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public Boolean addEmployee(EmployeeDTO employee) {
        return null;
    }

    @Override
    public Boolean updateEmployee(EmployeeDTO employee) {
        return null;
    }

    @Override
    public Boolean deleteEmployee(EmployeeDTO employee) {
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return null;
    }
}
