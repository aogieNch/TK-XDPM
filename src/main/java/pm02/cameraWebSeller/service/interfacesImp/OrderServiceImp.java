package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.OrderProduct;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.repository.OrderProductRepository;
import pm02.cameraWebSeller.data_access.repository.OrderRepository;
import pm02.cameraWebSeller.service.interfaces.OrderService;

import java.util.List;

@Service("orderService")
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImp(OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }
    @Override
    public void createOrder(Order order, List<Product> orderProducts) {

        order = orderRepository.save(order);

        for(Product op : orderProducts) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(op);
            orderProductRepository.save(orderProduct);
        }
    }
}
