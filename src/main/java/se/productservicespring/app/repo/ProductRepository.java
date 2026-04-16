package se.productservicespring.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.productservicespring.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
