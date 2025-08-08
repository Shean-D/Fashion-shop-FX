package service.custom;

import model.dto.EmployeeDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends SuperService {

    List<EmployeeDTO> getAllEmployees() throws SQLException;

    Boolean addEmployee(EmployeeDTO employee);

    Boolean updateEmployee(EmployeeDTO employee);

    Boolean deleteEmployee(EmployeeDTO employee);

    EmployeeDTO getEmployeeById(Integer id);
}
