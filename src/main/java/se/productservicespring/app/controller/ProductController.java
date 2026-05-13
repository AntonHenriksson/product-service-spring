package se.productservicespring.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.productservicespring.app.dto.ProductRequestId;
import se.productservicespring.app.dto.ProductResponse;
import se.productservicespring.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/sync")
    public ResponseEntity<List<ProductResponse>> fetchProductsFromExternalApi() {
        return ResponseEntity.ok(productService.fetchProductsFromFakeStore());
    }

    @GetMapping("/public/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/batch")
    public ResponseEntity<List<ProductResponse>> getCartProducts(@RequestBody List<ProductRequestId> products) {
        return ResponseEntity.ok(productService.getProductsByIds(products));
    }

    @GetMapping("/public/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
