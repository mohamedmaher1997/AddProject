package com.primefaces.demo.dao;

import com.primefaces.demo.domain.Product;
import java.util.List;

public interface ProductDAO {

    public Product getProductById(Integer productId);
    public List<Product> getAllProducts();
    public Product saveOrUpdateProduct(Product product);
    public Integer deleteProductById(Integer productId);

}
