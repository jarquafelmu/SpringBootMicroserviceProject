package com.terrazasdesigns.productservice.repository;

import com.terrazasdesigns.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

}