package service.custom.impl;

import model.dto.UserLogin;
import service.custom.UserLoginService;
import util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginServiceImpl implements UserLoginService {
    @Override
    public List<UserLogin> getAllUserLogins() throws SQLException {
        ResultSet resultSet = Crudutil.execute("select * from user_login");
        List<UserLogin> userLoginList = new ArrayList<>();
        while (resultSet.next()) {
            userLoginList.add(new UserLogin(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return userLoginList;
    }

    @Override
    public Boolean addUserLogin(UserLogin userLogin) {
        return null;
    }

    @Override
    public Boolean deleteUserLogin(UserLogin userLogin) {
        return null;
    }

    @Override
    public Boolean updateUserLogin(UserLogin userLogin) {
        return null;
    }

    @Override
    public UserLogin searchUserLogin(Integer id) {
        return null;
    }
}
