package pm02.cameraWebSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.entity.Title;
import pm02.cameraWebSeller.service.interfaces.AdminProductService;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {
    private final AdminProductService product;

    @Autowired
    public AdminProductController(AdminProductService product) {
        this.product = product;
    }
    @GetMapping("")
    public void getProducts() {
        product.getProducts();
    }
    @GetMapping("/")
    public void getProductById(@RequestParam String id) {
        product.getProductById(id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product newProduct, @RequestParam List<Title> titles) {
        return product.createProduct(newProduct, titles);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id,
                                                 @RequestBody Product updatedProduct,
                                                 @RequestBody List<Title> updatedTitles) {
        return product.updateProduct(id, updatedProduct, updatedTitles);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        product.deleteProduct(id);
    }
}
