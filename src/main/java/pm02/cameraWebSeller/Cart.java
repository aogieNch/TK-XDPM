package pm02.cameraWebSeller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Cart {
    private List<Product> products;
    private int quantity;
//    private double totalPrice;
//
//    public double getTotalPrice() {
//        totalPrice = 0;
//        for (Product product : products) {
//            totalPrice += product.getPrice();
//        }
//        return totalPrice;
//    }
    private Map<String, Integer> productQuantity;

    public Map<String, Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Map<String, Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void addProduct(Product product, int quantity) {
        if (productQuantity == null) {
            productQuantity = new HashMap<>();
        }

        if (products == null) {
            products = new ArrayList<>();
        }

        String productId = product.getId();

        if (productQuantity.containsKey(productId)) {
            int currentQuantity = productQuantity.get(productId);
            productQuantity.put(productId, currentQuantity + quantity);
        } else {
            productQuantity.put(productId, quantity);
            products.add(product);
        }
    }
}
