package se.productservicespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductServiceSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceSpringApplication.class, args);
    }

}
