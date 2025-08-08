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
        Transaction tx = null;

        try (Session session = HibernateUtil.getSession()) {

            order.setOrderID(null);
            tx = session.beginTransaction();

            for (OrderItemEntity item : order.getItemList()) {
                item.setOrder(order);

                // Load product (managed in this session)
                ProductEntity product = session.get(ProductEntity.class, item.getProduct().getProductsId());
                if (product == null) {
                    throw new IllegalArgumentException("Product not found: " + item.getProduct().getProductsId());
                }

                // Stock check
                if (product.getQtyOnHand() < item.getQuantity()) {
                    throw new IllegalArgumentException("Not enough stock for product: " + product.getProductName());
                }

                // Update stock (no merge needed)
                product.setQtyOnHand(product.getQtyOnHand() - item.getQuantity());

                // Attach managed product to order item
                item.setProduct(product);
            }

            // Persist order and items
            session.persist(order);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
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
