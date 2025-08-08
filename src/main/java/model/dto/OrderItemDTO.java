package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDTO {
    private Integer orderId;
    private Integer product_ID;
    private String productName;
    private Integer qty;
    private Double unitPrice;
    private Double total;

}
