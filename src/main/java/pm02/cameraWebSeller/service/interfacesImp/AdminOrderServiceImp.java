package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.repository.OrderRepository;
import pm02.cameraWebSeller.service.interfaces.AdminOrderService;

import java.util.List;

@Service("adminOrderService")
public class AdminOrderServiceImp implements AdminOrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public AdminOrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAllPendingOrder();
        if (orders.isEmpty())
            throw new RuntimeException("No order found");
        return orders;
    }

    @Override
    public Order getOrderById(String id) {
        Order order = orderRepository.findPendingOrderById(id);
        if (order == null)
            throw new RuntimeException("Order not found with id = " + id);
        return order;
    }
    @Override
    public void confirmOrder(String id) {
        Order order = orderRepository.findPendingOrderById(id);
        if (order == null)
            throw new RuntimeException("Order not found with id = " + id);
        order.setStatus("Confirmed");
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(String id) {
        Order order = orderRepository.findPendingOrderById(id);
        if (order == null)
            throw new RuntimeException("Order not found with id = " + id);
        order.setStatus("Canceled");
        orderRepository.save(order);
    }
}
