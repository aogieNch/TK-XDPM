package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;

import java.util.List;

@Service
@Qualifier("adminOrderService")
public interface AdminOrderService {
    List<Order> getOrders();
    Order getOrderById(String id);
    void confirmOrder(String id);
    void cancelOrder(String id);
}
