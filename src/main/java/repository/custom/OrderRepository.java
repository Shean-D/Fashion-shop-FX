package repository.custom;

import model.entity.OrderEntity;
import repository.SuperDao;

import java.util.List;

public interface OrderRepository extends SuperDao {

    List<OrderEntity> getAllOrders();

    Boolean addOrder(OrderEntity order);

    Boolean updateOrder(OrderEntity order);

    Boolean deleteOrder(OrderEntity order);

    OrderEntity getOrderById(Long id);

    Integer getOrderCount();

    Double getOrderTotal();

    Integer getOrderId();

}
