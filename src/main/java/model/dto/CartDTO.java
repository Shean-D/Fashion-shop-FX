package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private String id;
    private String description;
    private Integer qty;
    private Double unitprice;
    private Double total;
}
