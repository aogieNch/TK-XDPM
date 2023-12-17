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
    private double totalPrice;
    private Map<String, Integer> productQuantity;

    public double getTotalPrice() {
        double totalPrice = 0;
        if (products != null) {
            for (Product product : products) {
                totalPrice += product.getPrice() * productQuantity.get(product.getId());
            }
        }
        return totalPrice;
    }

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
    public void removeProduct(String productId) {
        if (products != null && productQuantity != null) {
            Product productToRemove = null;
            for (Product product : products) {
                if (product.getId().equals(productId)) {
                    productToRemove = product;
                    break;
                }
            }
            if (productToRemove != null) {
                products.remove(productToRemove);
                productQuantity.remove(productId);
            }
        }
    }
    public void decreaseProductQuantity(String productId) {
        if (products != null && productQuantity != null) {
            int currentQuantity = productQuantity.getOrDefault(productId, 0);
            if (currentQuantity > 1) {
                productQuantity.put(productId, currentQuantity - 1);
            } else {
                removeProduct(productId); // Remove the product if the quantity is 1 or less
            }
        }
    }

}
