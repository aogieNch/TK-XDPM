package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.OrderProduct;
import pm02.cameraWebSeller.service.interfaces.OrderService;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Override
    public Order createOrder(Order order, List<OrderProduct> orderProducts) {
        return null;
    }
}
