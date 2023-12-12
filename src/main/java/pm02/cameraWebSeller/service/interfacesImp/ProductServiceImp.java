package pm02.cameraWebSeller.service.interfacesImp;

import org.springframework.stereotype.Service;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.service.interfaces.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Override
    public List<Product> searchProduct(String keyword) {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }
}
