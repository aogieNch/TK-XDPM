package pm02.cameraWebSeller;

import jakarta.servlet.http.HttpSession;

public interface CartService {
    void addToCart(String productId, int quantity, HttpSession session);
    Cart viewCart(HttpSession session);
    void checkout(String name, String address, String phone, String gmail, HttpSession session);
    void removeFromCart(String productId, HttpSession session);
}
