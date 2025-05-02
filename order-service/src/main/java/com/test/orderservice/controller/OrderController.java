package com.test.orderservice.controller;

import com.test.orderservice.service.ProductServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "OrderController", description = "Endpoints of OrderController")
public class OrderController {

    private final ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/orders/{productId}")
    @Operation(summary = "Faccio un ordine di un prodotto")
    public Mono<String> createOrder(@PathVariable String productId) {
        return productServiceClient.reserveProduct(productId)
                .map(product -> "Order created for product: " + product.getName() + " with price: $" + product.getPrice());
    }
}
