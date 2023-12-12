package pm02.cameraWebSeller;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.OrderProduct;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.entity.Title;
import pm02.cameraWebSeller.data_access.repository.OrderProductRepository;
import pm02.cameraWebSeller.data_access.repository.OrderRepository;
import pm02.cameraWebSeller.data_access.repository.ProductRepository;
import pm02.cameraWebSeller.data_access.repository.TitleRepository;

@Service
public class TestDataSeeder {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final TitleRepository titleRepository;
    private final OrderProductRepository orderProductRepository;

    public TestDataSeeder(ProductRepository productRepository, OrderRepository orderRepository,
                          TitleRepository titleRepository, OrderProductRepository orderProductRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.titleRepository = titleRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public void insertTestData() {
        Product product1 = createProduct("Sample Product 1", 99.99f, "ABC Company");
        Product product2 = createProduct("Sample Product 2", 149.99f, "XYZ Corporation");

        Title title1 = createTitle("Title for Product 1", product1);
        Title title2 = createTitle("Another Title for Product 1", product1);

        Title title3 = createTitle("Title for Product 2", product2);

        Order order1 = createOrder();

        associateProductWithOrder(product1, order1, 2);
        associateProductWithOrder(product2, order1, 1);
    }

    private Product createProduct(String name, float price, String company) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCompany(company);
        return productRepository.save(product);
    }

    private Title createTitle(String name, Product product) {
        Title title = new Title();
        title.setName(name);
        title.setProduct(product);
        return titleRepository.save(title);
    }

    private Order createOrder() {
        Order order = new Order();
        order.setName("Sample Order 1");
        order.setAddress("123 Main St");
        return orderRepository.save(order);
    }

    private void associateProductWithOrder(Product product, Order order, int quantity) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);
        orderProduct.setQuantity(quantity);
        orderProductRepository.save(orderProduct);
    }
}



