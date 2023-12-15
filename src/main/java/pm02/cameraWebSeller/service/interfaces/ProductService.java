package pm02.cameraWebSeller.service.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pm02.cameraWebSeller.data_access.entity.Product;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("orderService")
public interface ProductService {
//    List<Product> searchProduct( String keyword);
    List<Product> findProductsByKeyword(String keyword);
    Optional<Product> getProductById(String id);

}
