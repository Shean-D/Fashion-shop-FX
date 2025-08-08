package repository.custom.Impl;

import model.dto.CustomerDTO;
import model.entity.CustomerEntity;
import org.hibernate.Session;
import repository.custom.CustomerRepository;
import util.HibernateUtil;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public CustomerEntity getCustomerByid(Integer id) {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        CustomerEntity customer = (CustomerEntity) session.get(CustomerEntity.class, id);
        session.getTransaction().commit();
        session.close();

        return customer;
    }

    @Override
    public Boolean save(CustomerEntity entity) {

        Session session = HibernateUtil.getSession();

        entity.setId(null);
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    @Override
    public Boolean update(CustomerEntity entity) {
        return null;
    }

    @Override
    public Boolean delete(CustomerEntity entity) {
        return null;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<CustomerEntity> customers = session.createQuery("FROM CustomerEntity", CustomerEntity.class).list();
        session.getTransaction().commit();
        session.close();
        return customers;

    }





}
