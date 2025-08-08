package util;

import model.dto.UserLogin;
import service.ServiceFactory;
import service.custom.UserLoginService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrentUser {

    private static UserLogin currentUser;

    private static UserLoginService loginServiceservice = ServiceFactory.getInstance().getServiceType(ServiceType.USERS);

    private static List<UserLogin> getUserLogins() throws SQLException {
         List<UserLogin> userLoginList = loginServiceservice.getAllUserLogins();
         return userLoginList;
    }

    public static Boolean checkLogin(String username, String password) throws SQLException {

        List<UserLogin> usersList = getUserLogins();

        for (UserLogin user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public static UserLogin getCurrentUser(){
        return currentUser;
    }

    public static String getCurrentUserName(){
        return currentUser.getUsername();
    }
}
