package com.furprprogress.testtask.application;

import com.furprprogress.testtask.application.interfaces.ProductService;
import com.furprprogress.testtask.domain.model.Product;
import com.furprprogress.testtask.infrastructure.interfaces.ProductRepository;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public void updateProduct(long id, Product product) {
        Product existingProduct = productRepository.getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());

        productRepository.updateProduct(existingProduct);
    }

    @Override
    public void deleteProductById(long id)
    {
        productRepository.deleteProductById(id);
    }
}