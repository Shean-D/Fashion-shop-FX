package service.custom;

import model.dto.OrderDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface OrderService extends SuperService {

    List<OrderDTO> getAllOrder();

    OrderDTO getOrderById(int id);

    Boolean addOrder(OrderDTO order) throws SQLException;

    Boolean updateOrder(OrderDTO order);

    Boolean deleteOrder(int id);

    Integer getOrderCount();

    Double getOrderSum();

    Integer getOrderId() throws SQLException;

}
