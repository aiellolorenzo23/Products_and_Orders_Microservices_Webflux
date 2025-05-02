package com.test.productservice.service;

import com.test.productservice.model.dto.CreateProduct;
import com.test.productservice.model.entity.Product;
import com.test.productservice.model.exceptions.ItemNotFoundException;
import com.test.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateProduct product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        return productRepository.save(newProduct);
    }

    public Product orderedProduct(UUID id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setQuantity(product.getQuantity() - 1);
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new ItemNotFoundException(id.toString()));
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id <"+id+"> not found in DB!"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
