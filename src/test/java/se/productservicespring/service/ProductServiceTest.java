package se.productservicespring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.productservicespring.app.dto.ProductResponse;
import se.productservicespring.app.model.Product;
import se.productservicespring.app.repo.ProductRepository;
import se.productservicespring.app.service.ProductService;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;


    @Test
    void getAllProducts() {

        //Arrange

        Product product = new Product();
        product.setId(1L);
        product.setProductId(1L);
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory("category");
        product.setImage("image");

        when(productRepository.findAll()).thenReturn(List.of(product));

        //Act

        List<ProductResponse> products = productService.getProducts();

        //Assert

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("title", products.getFirst().title());
    }

    @Test
    void getProductById() {

        //Arrange

        Product product = new Product();
        product.setId(1L);
        product.setProductId(1L);
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory("category");
        product.setImage("image");

        when(productRepository.findByProductId(1L)).thenReturn(Optional.of(product));

        //Act

        ProductResponse response = productService.getProduct(1L);

        //Assert

        assertNotNull(response);
        assertEquals(1L, response.productId());
        assertEquals("title", response.title());
    }



}
