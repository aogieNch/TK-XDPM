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
@Table(name = "product")
@CustomId(prefix = "pr.")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "pm02.cameraWebSeller.id_generator.IdGenerator")
    private String id;

    private String name;
    private float price;
    private String company;
    private String color;
    private int warranty;
    private Date dateCreate = new Date();

    @OneToMany(mappedBy = "product")
    private List<Title> titles;

    @OneToMany(mappedBy="product")
    private List<OrderProduct> orderProducts;
}
