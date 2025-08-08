package service.custom.impl;

import model.dto.EmployeeDTO;
import service.custom.EmployeeService;
import util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeDTO> getAllEmployees() throws SQLException {
        ResultSet resultSet = Crudutil.execute("select * from employee");
        List<EmployeeDTO> employeeList = new ArrayList<>();
        while (resultSet.next()){
            employeeList.add(new EmployeeDTO(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return employeeList;
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
