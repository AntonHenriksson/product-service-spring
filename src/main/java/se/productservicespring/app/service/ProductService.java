package se.productservicespring.app.service;

import org.springframework.stereotype.Service;
import se.productservicespring.app.repo.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
