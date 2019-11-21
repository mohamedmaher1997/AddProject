package com.primefaces.demo.service;

import com.primefaces.demo.dao.ProductDAO;
import com.primefaces.demo.domain.Product;
import com.primefaces.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductDAO {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Integer deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
        return productId;
    }
}
