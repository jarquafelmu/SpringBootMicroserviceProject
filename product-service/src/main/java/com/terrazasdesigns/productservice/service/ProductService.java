package com.terrazasdesigns.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.terrazasdesigns.productservice.dto.ProductRequest;
import com.terrazasdesigns.productservice.dto.ProductResponse;
import com.terrazasdesigns.productservice.model.Product;
import com.terrazasdesigns.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor // creates a constructor with all required fields at compile time
@Slf4j
public class ProductService {
  
  private final ProductRepository productRepository;

  public void createProduct(ProductRequest productRequest) {
    // Create a new product
    Product product = Product.builder()
      .name(productRequest.getName())
      .description(productRequest.getDescription())
      .price(productRequest.getPrice())
      .build();

    // save product to the database  
    productRepository.save(product);
    log.info("Product created: {}", product.getId());
  }

  public List<ProductResponse> getAllProducts() {
    // Get all products from the database
    List<Product> products = productRepository.findAll();
    log.info("Retrieved all products: {}", products);
    return products.stream()
      .map(this::mapToProductResponse) // same as: product -> mapToProductResponse(product)
      .toList();
  }

  private ProductResponse mapToProductResponse(Product product) {
    return ProductResponse.builder()
      .id(product.getId())
      .name(product.getName())
      .description(product.getDescription())
      .price(product.getPrice())
      .build();
  }
}
