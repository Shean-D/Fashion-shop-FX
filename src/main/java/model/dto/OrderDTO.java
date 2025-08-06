package model.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
    private Long orderID;
    private String customerName;
    private Integer employeeID;
    private String employeeName;
    private Double totalPrice;
    private LocalDate orderDate;
    private List<OrderItemDTO> itemList;
}
