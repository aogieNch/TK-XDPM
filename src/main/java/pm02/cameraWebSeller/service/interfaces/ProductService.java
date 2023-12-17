package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm02.cameraWebSeller.data_access.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("productService")
public interface ProductService {
    Product getProductById(String id);
    @Transactional(readOnly = true)
    Product getProductWithTitles(String productId);
    List<Product> findProductsByKeyword(String keyword);
    Optional<Product> getOptionalProductById(String id);
}
