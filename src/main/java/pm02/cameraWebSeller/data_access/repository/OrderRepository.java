package pm02.cameraWebSeller.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pm02.cameraWebSeller.data_access.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Query("select o from Order o where o.id = :id and o.status = 'Pending'")
    Order findPendingOrderById(String id);
    @Query("select o from Order o where o.status = 'Pending'")
    List<Order> findAllPendingOrder();
}
