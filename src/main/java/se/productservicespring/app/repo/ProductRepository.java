package se.productservicespring.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.productservicespring.app.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Long productId);

    List<Product> findAllByIdIn(List<Long> ids);
}
