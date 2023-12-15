package pm02.cameraWebSeller.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
//    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
List<Product> findProductsByKeyword(@Param("keyword") String keyword);

    Optional<Product> findById(String id);
}
