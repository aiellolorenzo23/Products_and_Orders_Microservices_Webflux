package com.test.orderservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Product", description = "DTO Product")
public class Product {
    @Schema(name = "id", type = "string")
    private UUID id;
    @Schema(name = "name", type = "string")
    private String name;
    @Schema(name = "price", type = "number")
    private double price;
    @Schema(name = "quantity", type = "integer")
    private int quantity;
}
