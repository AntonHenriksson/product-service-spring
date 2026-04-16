package se.productservicespring.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.productservicespring.app.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Long productId);
}
