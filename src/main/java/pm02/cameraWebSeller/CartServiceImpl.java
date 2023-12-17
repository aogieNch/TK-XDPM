package pm02.cameraWebSeller;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.service.interfaces.OrderService;
import pm02.cameraWebSeller.service.interfaces.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private static final String SECRET_SESSION_KEY = "MY_SESSION_KEY";
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public CartServiceImpl(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    private Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(SECRET_SESSION_KEY);

        if (cart == null) {
            cart = new Cart();
            session.setAttribute(SECRET_SESSION_KEY, cart);
        }

        return cart;
    }

    @Override
    public void addToCart(String productId, int quantity, HttpSession session) {
        Cart cart = getCart(session);
        Product productToAdd = productService.getProductById(productId);

        if (quantity == 0) {
            quantity = 1;
        }
        if (productToAdd != null) {
            cart.addProduct(productToAdd, quantity);
            session.setAttribute(SECRET_SESSION_KEY, cart);
        }
    }
    @Override
    public void decreaseQuantity(String productId, HttpSession session) {
        Cart cart = getCart(session);
        cart.decreaseProductQuantity(productId);
        session.setAttribute(SECRET_SESSION_KEY, cart);
    }
    @Override
    public Cart viewCart(HttpSession session) {
        Cart cart = getCart(session);

        if (cart.getProducts() != null) {
            List<Product> updatedProducts = new ArrayList<>();
            for (Product product : cart.getProducts()) {
                Product productWithTitles = productService.getProductWithTitles(product.getId());
                if (productWithTitles != null) {
                    updatedProducts.add(productWithTitles);
                }
            }
            cart.setProducts(updatedProducts);
        }

        return cart;
    }

    @Override
    public void checkout(String name, String address, String phone, String gmail, HttpSession session) {
        Cart cart = getCart(session);

        if (!cart.getProducts().isEmpty()) {
            Order newOrder = new Order();
            newOrder.setName(name);
            newOrder.setAddress(address);
            newOrder.setPhone(phone);
            newOrder.setGmail(gmail);

            orderService.createOrder(newOrder, cart.getProducts());

            // Clear the cart after successful order creation
            session.setAttribute(SECRET_SESSION_KEY, cart);
        }
    }
    @Override
    public void removeFromCart(String productId, HttpSession session) {
        Cart cart = getCart(session);
        cart.removeProduct(productId);
        session.setAttribute(SECRET_SESSION_KEY, cart);
    }
}
