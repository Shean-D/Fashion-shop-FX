package model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id")
    private Integer productsId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "size", length = 10)
    private String size;

    @Column(name = "price")
    private Double price;

    @Column(name = "qty_on_hand")
    private Integer qtyOnHand;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "supplier", length = 100)
    private String supplier;
}
