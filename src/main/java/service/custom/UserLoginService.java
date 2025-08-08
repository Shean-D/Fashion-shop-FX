package service.custom;

import model.dto.UserLogin;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface UserLoginService extends SuperService {

    List<UserLogin> getAllUserLogins() throws SQLException;

    Boolean addUserLogin(UserLogin userLogin);

    Boolean deleteUserLogin(UserLogin userLogin);

    Boolean updateUserLogin(UserLogin userLogin);

    UserLogin searchUserLogin(Integer id);
}
