package pm02.cameraWebSeller.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pm02.cameraWebSeller.data_access.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
