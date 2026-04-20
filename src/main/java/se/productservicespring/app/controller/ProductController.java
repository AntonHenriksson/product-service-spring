package se.productservicespring.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @GetMapping("/sync")
    public ResponseEntity<List<ProductResponse>> fetchProductsFromExternalApi() {
        return ResponseEntity.ok(productService.fetchProductsFromFakeStore());
    }
}
