package com.terrazasdesigns.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Good practice to have a separate DTO (Data Transfer Object) for response from the models to not expose the internal structure of the model

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
  private String id;
  private String name;
  private String description;
  private BigDecimal price;
}
