package com.furprprogress.testtask.infrastructure.repositories;

import com.furprprogress.testtask.domain.model.Product;
import com.furprprogress.testtask.infrastructure.configs.MyBatisUtilities;
import com.furprprogress.testtask.infrastructure.configs.ProductMapper;
import com.furprprogress.testtask.infrastructure.interfaces.ProductRepository;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import java.util.UUID;

public class MyBatisProductRepository implements ProductRepository {

    private final SqlSession sqlSession;
    private final ProductMapper productMapper;

    public MyBatisProductRepository() {
        this.sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession();
        this.productMapper = sqlSession.getMapper(ProductMapper.class);
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public Product getProductById(UUID id) {
        return productMapper.getProductById(id);
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
        sqlSession.commit();
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
        sqlSession.commit();
    }

    @Override
    public void deleteProductById(UUID id) {
        productMapper.deleteProductById(id);
        sqlSession.commit();
    }
}
