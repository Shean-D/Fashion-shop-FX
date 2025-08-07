package repository;

import repository.custom.CustomerRepository;
import repository.custom.Impl.CustomerRepositoryImpl;
import repository.custom.Impl.OrderRepositoryImpl;
import repository.custom.Impl.ProductRepositoryImpl;
import util.DaoType;

public class DaoFactory {

    private static DaoFactory instance;

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDao> T getDaoType(DaoType type){

        switch (type){
            case CUSTOMER : return (T) new CustomerRepositoryImpl();
            case PRODUCT: return (T) new ProductRepositoryImpl();
            case ORDER: return (T) new OrderRepositoryImpl();
        }
        return null;
    }
}
