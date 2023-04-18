package com.furprprogress.testtask.application.interfaces;

import com.furprprogress.testtask.domain.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    void addProduct(Product product);
    void updateProduct(long id, Product product);
    void deleteProductById(long id);
}
