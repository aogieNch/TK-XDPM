package pm02.cameraWebSeller;

import jakarta.servlet.http.HttpSession;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.Map;

public interface CartService {
    void addToCart(String productId, int quantity, HttpSession session);
    Cart viewCart(HttpSession session);

    void checkout(String name, String address, String phone, String gmail, HttpSession session);
}
