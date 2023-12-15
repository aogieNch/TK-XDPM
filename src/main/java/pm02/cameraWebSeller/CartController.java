package pm02.cameraWebSeller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.reponse.ResponseObject;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("")
    public String addToCart(@RequestBody CartRequest request, HttpSession session) {
        try{
            cartService.addToCart(request.getProductId(), request.getQuantity(), session);
            return "Item(s) added to the cart";
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("")
    public ResponseEntity<Cart> viewCart(HttpSession session) {
        Cart cartContents = cartService.viewCart(session);
        return ResponseEntity.ok(cartContents);
    }

    @PostMapping("checkout")
    public ResponseEntity<ResponseObject> checkout(@RequestBody CartRequest request, HttpSession session) {
        try{
            cartService.checkout(
                    request.getName(),
                    request.getAddress(),
                    request.getPhone(),
                    request.getGmail(),
                    session
            );
            return ResponseEntity.ok(new ResponseObject("OK", "Checkout successful", null));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseObject("ERROR", e.getMessage(), null));
        }
    }
}

