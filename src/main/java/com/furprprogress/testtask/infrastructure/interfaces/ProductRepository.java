package com.furprprogress.testtask.infrastructure.interfaces;

import com.furprprogress.testtask.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(long id);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(long id);
}