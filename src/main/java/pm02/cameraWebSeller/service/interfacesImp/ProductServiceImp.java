package pm02.cameraWebSeller.service.interfacesImp;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.repository.ProductRepository;
import pm02.cameraWebSeller.service.interfaces.ProductService;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductsByKeyword(String keyword) {
        return productRepository.findProductsByKeyword(keyword);
    }
    @Override
    public Optional<Product> getOptionalProductById(String id) {
        return productRepository.findById(id);
    }
    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public Product getProductWithTitles(String productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            Hibernate.initialize(product.getTitles());
        }
        return product;
    }
}
