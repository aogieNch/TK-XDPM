package pm02.cameraWebSeller.service.interfaces;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.OrderProduct;

import java.util.List;

@Service
public interface OrderService {
    Order createOrder(Order order, List<OrderProduct> orderProducts);
}
