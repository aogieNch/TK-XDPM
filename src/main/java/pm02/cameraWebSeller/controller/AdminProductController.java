package pm02.cameraWebSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.reponse.ResponseObject;
import pm02.cameraWebSeller.service.interfaces.AdminProductService;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
public class AdminProductController {
    private final AdminProductService product;

    @Autowired
    public AdminProductController(AdminProductService product) {
        this.product = product;
    }
    @GetMapping("")
    public ResponseObject getProducts() {
        List<Product> products = product.getProducts();
        return new ResponseObject("OK", "Successfully retrieved all products", products);
    }
    @GetMapping("/")
    public ResponseObject getProductById(@RequestParam String id) {
        Product product = this.product.getProductById(id);
        return new ResponseObject("OK", "Successfully retrieved product by ID = " + id, product);
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> createProduct(@RequestBody ProductRequest productRequest) {
        Product createdProduct = this.product.createProduct(
                productRequest.getProduct(),
                productRequest.getTitles()
        );
        return ResponseEntity.ok(
                new ResponseObject("CREATED", "Create product successfully", createdProduct)
        );
    }

    @PutMapping("")
    public ResponseObject updateProduct(@RequestParam String id,
                                        @RequestBody ProductRequest request) {
        Product updatedProduct = this.product.updateProduct(id, request.getProduct(), request.getTitles());
        return new ResponseObject("OK", "Update product successfully", updatedProduct);
    }

    @DeleteMapping("")
    public ResponseObject deleteProduct(@RequestParam String id) {
        this.product.deleteProduct(id);
        return new ResponseObject("OK", "Delete product successfully", null);
    }
}
