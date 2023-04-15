package com.furprprogress.testtask.application;

import com.furprprogress.testtask.domain.DTOs.ProductDto;
import com.furprprogress.testtask.domain.model.Product;
import com.furprprogress.testtask.infrastructure.interfaces.ProductRepository;
import jakarta.inject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = this.productRepository.getAllProducts();
        List<ProductDto> productDTOs = new ArrayList<>();

        for (Product product : products) {
            productDTOs.add(new ProductDto(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice()
            ));
        }
        return productDTOs;
    }

    public ProductDto getProductById(UUID id) {
        Product product = productRepository.getProductById(id);

        if (product.getId().equals(id)) {
            return new ProductDto(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice()
            );
        }

        return null;
    }

    public void createProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
        productRepository.insertProduct(product);
    }

    public void updateProduct(UUID id, ProductDto productdto) {
        var product = productRepository.getProductById(id);

        product.setName(productdto.getName());
        product.setDescription(productdto.getDescription());
        product.setPrice(productdto.getPrice());

        productRepository.updateProduct(product);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteProductById(id);
    }
}