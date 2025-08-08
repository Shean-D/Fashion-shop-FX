package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private Integer orderID;
    private String customerID;
    private String employeeID;
    private String employeeName;
    private Double totalPrice;
    private String orderDate;
    private List<OrderItemDTO> itemList;
}
