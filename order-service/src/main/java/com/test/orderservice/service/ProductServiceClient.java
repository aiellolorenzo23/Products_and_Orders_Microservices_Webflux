package com.test.orderservice.service;

import com.test.orderservice.model.dto.Product;
import com.test.orderservice.model.exceptions.OutOfStockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceClient {

    private final WebClient.Builder webClientBuilder;
    private final String productServiceUrl;

    public ProductServiceClient(WebClient.Builder webClientBuilder, @Value("${product.service.url}") String productServiceUrl) {
        this.webClientBuilder = webClientBuilder;
        this.productServiceUrl = productServiceUrl;
    }

    public Mono<Product> reserveProduct(String productId) {
        return webClientBuilder.build()
                .get()
                .uri(productServiceUrl + "/get/" + productId)
                .retrieve()
                .bodyToMono(Product.class)
                .flatMap(product -> {
                    if (product.getQuantity() > 0) {
                        return webClientBuilder.build()
                                .put()
                                .uri(productServiceUrl + "/ordered/" + product.getId())
                                .bodyValue(product)
                                .retrieve()
                                .bodyToMono(Product.class);
                    } else {
                        return Mono.error(new OutOfStockException("Spiacenti, ma il prodotto con id <"+productId+"> non è attualmente in stock!"));
                    }
                });
    }

}
