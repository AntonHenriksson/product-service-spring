package se.productservicespring.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.productservicespring.app.dto.ProductRequest;

import java.util.List;

@Service
public class FakeStoreClientService {

    private final WebClient webClient;

    public FakeStoreClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<ProductRequest> fetchExternalProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductRequest.class)
                .collectList()
                .block();
    }


}
