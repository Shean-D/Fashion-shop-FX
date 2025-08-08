package service.custom.impl;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.dto.OrderDTO;
import service.custom.OrderService;
import util.Crudutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderDTO> getAllOrder() {
        return List.of();
    }

    @Override
    public OrderDTO getOrderById(int id) {
        return null;
    }

    @Override
    public Boolean addOrder(OrderDTO order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            PreparedStatement  pstm = connection.prepareStatement(sql);
            pstm.setObject(1, order.getOrderID());
            pstm.setObject(2, order.getCustomerID());
            pstm.setObject(3, order.getEmployeeID());
            pstm.setObject(4, order.getEmployeeName());
            pstm.setObject(5, order.getTotalPrice());
            pstm.setObject(6, order.getOrderDate());


            boolean isOrderAdd = pstm.executeUpdate() > 0;

            if (isOrderAdd){
                 Boolean isOrderDetailsAdd = new OrderDetailServiceImpl().addOrderDetails(order.getItemList());

                 if (isOrderDetailsAdd){
                      Boolean isUpdateStock = new ProductServiceImpl().updateStock(order.getItemList());

                      if (isUpdateStock){
                          new Alert(Alert.AlertType.CONFIRMATION,"Order placed successfully").showAndWait();
                          connection.commit();
                      }
                 }
            }
            connection.rollback();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }finally {
            connection.setAutoCommit(true);
        }

        return null;
    }

    @Override
    public Boolean updateOrder(OrderDTO order) {
        return null;
    }

    @Override
    public Boolean deleteOrder(int id) {
        return null;
    }

    @Override
    public Integer getOrderCount() {
        return 0;
    }

    @Override
    public Double getOrderSum() {
        return 0.0;
    }

    @Override
    public Integer getOrderId() throws SQLException {
        ResultSet resultSet = Crudutil.execute("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1;");

        if (resultSet.next()){
            return resultSet.getInt("order_id");
        }
        return 0;
    }
}
