package com.furprprogress.testtask.infrastructure.repositories;

import com.furprprogress.testtask.domain.model.Product;
import com.furprprogress.testtask.infrastructure.configs.MyBatisUtilities;
import com.furprprogress.testtask.infrastructure.configs.ProductMapper;
import com.furprprogress.testtask.infrastructure.interfaces.ProductRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getAllProducts() {
        try (SqlSession sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.getAllProducts();
        }
    }

    @Override
    public Product getProductById(long id) {
        try (SqlSession sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.getProductById(id);
        }
    }

    @Override
    public void insertProduct(Product product) {
        try (SqlSession sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.insertProduct(product);
            sqlSession.commit();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (SqlSession sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.updateProduct(product);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteProductById(long id) {
        try (SqlSession sqlSession = MyBatisUtilities.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.deleteProductById(id);
            sqlSession.commit();
        }
    }
}