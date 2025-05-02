package com.test.productservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CreateProduct", description = "DTO Product")
public class CreateProduct {
    @Schema(name = "name", type = "string")
    private String name;
    @Schema(name = "price", type = "number")
    private double price;
    @Schema(name = "quantity", type = "integer")
    private int quantity;
}
