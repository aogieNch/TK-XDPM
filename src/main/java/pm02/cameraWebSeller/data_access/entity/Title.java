package pm02.cameraWebSeller.data_access.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import pm02.cameraWebSeller.id_generator.CustomId;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "title")
@CustomId(prefix = "t.")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "pm02.cameraWebSeller.id_generator.IdGenerator")
    private String id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
