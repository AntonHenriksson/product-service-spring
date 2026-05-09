package se.productservicespring.app.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import se.productservicespring.app.dto.ProductRequest;
import se.productservicespring.app.dto.ProductResponse;
import se.productservicespring.app.mapper.ProductMapper;
import se.productservicespring.app.model.Product;
import se.productservicespring.app.repo.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FakeStoreClientService fakeStoreClientService;


    public ProductService(ProductRepository productRepository, FakeStoreClientService fakeStoreClientService) {
        this.productRepository = productRepository;
        this.fakeStoreClientService = fakeStoreClientService;
    }

    // the dumb method that calls syncing from fake-store
    @Scheduled(fixedRate = 60000)
    @Transactional
    public List<ProductResponse> fetchProductsFromFakeStore() {
        Date now = new Date();
        System.out.println("Fetching products from fake store" + now);
        System.out.println("Fetching products from fake store" + now);
        System.out.println("Fetching products from fake store" + now);
        return syncProducts(fakeStoreClientService.fetchExternalProducts());
    }

    //Todo add safety here
    @Transactional
    public List<ProductResponse> syncProducts(List<ProductRequest> requests) {
        List<Product> productsToSave = requests
                .stream()
                .map(ProductMapper::toProduct)
                .toList();

        List<Product> savedProducts = productRepository.saveAll(productsToSave);

        return savedProducts
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Transactional
    public List<ProductResponse> getProducts() {
        if (productRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("No products found");
        }
        return productRepository
                .findAll()
                .stream()
                .map(ProductMapper::toResponse).toList();
    }

    @Transactional
    public ProductResponse getProduct(Long productId) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return ProductMapper.toResponse(product);
    }

}

