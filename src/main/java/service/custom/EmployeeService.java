package service.custom;

import model.dto.EmployeeDTO;
import service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {

    List<EmployeeDTO> getAllEmployees();

    Boolean addEmployee(EmployeeDTO employee);

    Boolean updateEmployee(EmployeeDTO employee);

    Boolean deleteEmployee(EmployeeDTO employee);

    EmployeeDTO getEmployeeById(Integer id);
}
