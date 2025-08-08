package model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderID;

    @Column(name = "customer_id", nullable = false)
    private String customerID;

    @Column(name = "employee_id", nullable = false)
    private String employeeID;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<OrderItemEntity> itemList;
}
