package com.furprprogress.testtask.infrastructure.interfaces;

import com.furprprogress.testtask.domain.model.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM products")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price")
    })
    List<Product> getAllProducts();

    @Select("SELECT * FROM products WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price")
    })
    Product getProductById(UUID id);

    @Insert("INSERT INTO products (name, description, price) VALUES (#{name}, #{description}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(Product product);

    @Update("UPDATE products SET name = #{name}, description = #{description}, price = #{price} WHERE id = #{id}")
    void updateProduct(Product product);

    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteProductById(UUID id);
}