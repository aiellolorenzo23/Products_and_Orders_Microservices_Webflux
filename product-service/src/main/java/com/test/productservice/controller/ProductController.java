package com.test.productservice.controller;

import com.test.productservice.model.dto.CreateProduct;
import com.test.productservice.model.entity.Product;
import com.test.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@Tag(name = "ProductController", description = "Endpoints of ProductController")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @Operation(summary = "Creo un prodotto e lo inserisco in inventario")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProduct product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Cerco un prodotto dal suo id")
    public ResponseEntity<Product> getProduct(@PathVariable UUID id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/get/all")
    @Operation(summary = "Lista di tutti i prodotti")
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PutMapping("/ordered/{id}")
    @Operation(summary = "Decrementa lo stock di un prodotto ordinato")
    public ResponseEntity<Product> list(@PathVariable UUID id) {
        return ResponseEntity.ok().body(productService.orderedProduct(id));
    }
}
