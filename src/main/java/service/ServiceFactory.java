package service;

import service.custom.impl.*;
import util.ServiceType;

public class ServiceFactory {

    private static ServiceFactory instance;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance==null?instance=new ServiceFactory():instance;
    }

    public <T extends SuperService> T getServiceType(ServiceType type){

        switch (type){
            case CUSTOMER : return (T) new CustomerServiceImpl();
            case PRODUCT: return (T) new ProductServiceImpl();
            case ORDER: return (T) new OrderServiceImpl();
            case SUPPLIER: return (T) new SupplierServiceImpl();
            case EMPLOYEE: return (T) new EmployeeServiceImpl();
            case CATEGORY: return (T) new CategoryServiceImpl();
            case USERS: return (T) new UserLoginServiceImpl();

        }
        return null;
    }

}
