package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.entity.Title;
import pm02.cameraWebSeller.data_access.repository.ProductRepository;
import pm02.cameraWebSeller.data_access.repository.TitleRepository;
import pm02.cameraWebSeller.service.interfaces.AdminProductService;

import java.util.Collections;
import java.util.List;

@Service("adminProductService")
public class AdminProductServiceImp implements AdminProductService {
    private final ProductRepository productRepository;
    private final TitleRepository titleRepository;

    @Autowired
    public AdminProductServiceImp(ProductRepository productRepository, TitleRepository titleRepository) {
        this.productRepository = productRepository;
        this.titleRepository = titleRepository;
    }
    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new RuntimeException("No product found");
        return products;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id = " + id));
    }

    @Override
    public Product createProduct(Product product, List<Title> titles) {
        product.setOrderProducts(Collections.emptyList());
        Product savedProduct = productRepository.save(product);

        if (titles != null && !titles.isEmpty()) {
            for (Title title : titles) {
                title.setProduct(savedProduct);
                titleRepository.save(title);
            }
            savedProduct.setTitles(titles);
        }

        return savedProduct;
    }

    @Override
    public Product updateProduct(String id, Product updatedProduct, List<Title> updatedTitles) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id = " + id));

        if (updatedProduct.getName() != null)
            existingProduct.setName(updatedProduct.getName());
        if (updatedProduct.getPrice() != 0)
            existingProduct.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getCompany() != null)
            existingProduct.setCompany(updatedProduct.getCompany());
        if (updatedProduct.getColor() != null)
            existingProduct.setColor(updatedProduct.getColor());
        if (updatedProduct.getWarranty() != 0)
            existingProduct.setWarranty(updatedProduct.getWarranty());

        if (updatedTitles != null && !updatedTitles.isEmpty()) {
            existingProduct.getTitles().clear();
            existingProduct.getTitles().addAll(updatedTitles);
            updatedTitles.forEach(title -> title.setProduct(existingProduct));
        }

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id = " + id));

        List<Title> titles = product.getTitles();
        titles.forEach(title -> {
            title.setProduct(null);
            titleRepository.delete(title);
        });

        productRepository.delete(product);
    }

}
