package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.List;

@Service
@Qualifier("productService")
public interface ProductService {
    List<Product> searchProduct(String keyword);
    Product getProductById(String id);

    @Transactional(readOnly = true)
    Product getProductWithTitles(String productId);
}
