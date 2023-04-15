package com.furprprogress.testtask.infrastructure.repositories;

import com.furprprogress.testtask.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int id);
}