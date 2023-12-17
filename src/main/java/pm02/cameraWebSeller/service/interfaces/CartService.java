package pm02.cameraWebSeller.service.interfaces;

import jakarta.servlet.http.HttpSession;
import pm02.cameraWebSeller.data_access.entity.Cart;

public interface CartService {
    void addToCart(String productId, int quantity, HttpSession session);
    void decreaseQuantity(String productId, HttpSession session);
    Cart viewCart(HttpSession session);
    void checkout(String name, String address, String phone, String gmail, HttpSession session);
    void removeFromCart(String productId, HttpSession session);
}
