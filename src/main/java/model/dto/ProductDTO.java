package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Integer productsId;
    private String productName;
    private String size;
    private Double price;
    private Integer qtyOnHand;
    private String category;
    private String supplier;
}
