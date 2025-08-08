package repository.custom.Impl;


import model.entity.OrderEntity;
import model.entity.OrderItemEntity;
import model.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.OrderRepository;
import util.HibernateUtil;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public List<OrderEntity> getAllOrders() {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        List<OrderEntity> orders = session.createQuery("from OrderEntity", OrderEntity.class).list();
        session.getTransaction().commit();
        session.close();

        return orders;
    }

    @Override
    public Boolean addOrder(OrderEntity order) {

        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();

            session.save(order);

            new ProductRepositoryImpl().updateStock(session,order.getItemList());

            new OrderDetailsRepositoryImpl().addOrderDetails(session,order.getItemList());

            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }

    }

    @Override
    public Boolean updateOrder(OrderEntity order) {
        return null;
    }

    @Override
    public Boolean deleteOrder(OrderEntity order) {
        return null;
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        return null;
    }

    @Override
    public Integer getOrderCount() {
        return 0;
    }

    @Override
    public Double getOrderTotal() {
        return 0.0;
    }

    @Override
    public Integer getOrderId() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Integer lastId = session.createQuery(
                    "select max(o.orderID) from OrderEntity o", Integer.class
            ).uniqueResult();

            session.getTransaction().commit();

            return (lastId != null) ? lastId : 0; // return 0 if no orders
        }
    }

}
