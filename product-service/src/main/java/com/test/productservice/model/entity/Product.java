package com.test.productservice.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
@Schema(name = "Product", description = "Items")
public class Product {
    @Id
    @GeneratedValue
    @Schema(name = "id", type = "string")
    private UUID id;
    @Schema(name = "name", type = "string")
    private String name;
    @Schema(name = "price", type = "number")
    private double price;
    @Schema(name = "price", type = "integer")
    private int quantity;
}
