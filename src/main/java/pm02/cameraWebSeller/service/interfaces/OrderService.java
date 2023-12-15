package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.List;

@Service
@Qualifier("orderService")
public interface OrderService {
    void createOrder(Order order, List<Product> orderProducts);
}
