package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.entity.Title;

import java.util.List;

@Service
@Qualifier("adminProductService")
public interface AdminProductService {
    List<Product> getProducts();
    Product getProductById(String id);
    Product createProduct(Product product, List<Title> titles);
    Product updateProduct(String id, Product product, List<Title> titles);
    void deleteProduct(String id);
}
