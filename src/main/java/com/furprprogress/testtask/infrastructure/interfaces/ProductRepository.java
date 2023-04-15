package com.furprprogress.testtask.infrastructure.interfaces;

import com.furprprogress.testtask.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(UUID id);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(UUID id);
}