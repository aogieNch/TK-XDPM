package pm02.cameraWebSeller.data_access.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("product-order-products")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonBackReference("order-products")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id", insertable = false, updatable = false)
    private String productId;

    @Column(name = "order_id", insertable = false, updatable = false)
    private String orderId;

    private int quantity;
}
