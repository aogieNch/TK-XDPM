package pm02.cameraWebSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.service.interfaces.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/search")
//    public List<Product> searchProducts(@RequestParam String keyword) {
//        return productService.searchProduct(keyword);
//    }
@GetMapping("/search")
public ResponseEntity<List<Product>> getProducts(@RequestParam("keyword") String keyword) {
    List<Product> products = productService.findProductsByKeyword(keyword);
    return new ResponseEntity<>(products, HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
