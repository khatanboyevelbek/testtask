package com.furprprogress.testtask.infrastructure.configs;

import com.furprprogress.testtask.domain.model.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.UUID;

public interface ProductMapper {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(long id);
}