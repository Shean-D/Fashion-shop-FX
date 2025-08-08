package service.custom.impl;

import model.dto.OrderItemDTO;
import util.Crudutil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceImpl {

    public Boolean addOrderDetails(List<OrderItemDTO> orderDetails) throws SQLException {

        for (OrderItemDTO item : orderDetails) {
            Boolean isAdd = addOrderDetails(item);

            if (!isAdd) {
                return false;
            }
        }
        return true;
    }

    public Boolean addOrderDetails(OrderItemDTO item) throws SQLException {

       return Crudutil.execute("INSERT INTO order_items (order_id, product_id, quantity, unit_price, total) VALUES (?, ?, ?, ?, ?)",
                item.getOrderId(),
                item.getProduct_ID(),
                item.getQty(),
                item.getUnitPrice(),
                item.getTotal());
    }
}
