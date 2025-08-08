package service.custom.impl;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.dto.OrderDTO;
import model.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.OrderRepository;
import service.custom.OrderService;
import util.Crudutil;
import util.DaoType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderRepository repository = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<OrderDTO> getAllOrder() {

        List<OrderEntity> allOrders = repository.getAllOrders();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (OrderEntity order : allOrders) {
            orderDTOs.add(modelMapper.map(order, OrderDTO.class));
        }
        return orderDTOs;
    }

    @Override
    public OrderDTO getOrderById(int id) {
        return null;
    }

    @Override
    public Boolean addOrder(OrderDTO order) throws SQLException {

            OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
            return repository.addOrder(orderEntity);
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
        return 0;
    }

}

