package pm02.cameraWebSeller.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pm02.cameraWebSeller.data_access.entity.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, String> {
}
