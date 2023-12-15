package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.service.interfaces.ProductService;
import pm02.cameraWebSeller.data_access.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Override
//    public List<Product> searchProduct(String keyword) {
//        return productRepository.findByNameContainingOrDescriptionContaining(keyword, keyword);
//    }
    @Override
    public List<Product> findProductsByKeyword(String keyword) {
    return productRepository.findProductsByKeyword(keyword);
}
    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
}
