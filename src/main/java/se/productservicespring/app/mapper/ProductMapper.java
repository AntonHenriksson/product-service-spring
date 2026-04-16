package se.productservicespring.app.mapper;

import se.productservicespring.app.dto.ProductRequest;
import se.productservicespring.app.dto.ProductResponse;
import se.productservicespring.app.model.Product;

public class ProductMapper {

    public static Product toProduct(ProductRequest request) {
        Product product = new Product();
        product.setProductId(request.productId());
        product.setPrice(request.price());
        product.setTitle(request.title());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setImage(request.image());
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getProductId(),
                product.getPrice(),
                product.getTitle(),
                product.getDescription(),
                product.getCategory(),
                product.getImage());
    }
}
