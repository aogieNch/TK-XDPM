package pm02.cameraWebSeller.data_access.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import pm02.cameraWebSeller.id_generator.CustomId;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@CustomId(prefix = "or.")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "pm02.cameraWebSeller.id_generator.IdGenerator")
    private String id;

    private String name;
    private String address;
    private String phone;
    private String gmail;
    private Date dateOrder = new Date();
    private String status;

    @OneToMany(mappedBy="order")
    private List<OrderProduct> orderProducts;
}

