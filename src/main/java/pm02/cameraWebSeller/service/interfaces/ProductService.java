package pm02.cameraWebSeller.service.interfaces;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.List;

@Service
public interface ProductService {
    List<Product> searchProduct(String keyword);
    Product getProductById(String id);
}
