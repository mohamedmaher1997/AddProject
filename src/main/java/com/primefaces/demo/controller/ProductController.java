package com.primefaces.demo.controller;

import com.primefaces.demo.dao.ProductDAO;
import com.primefaces.demo.domain.Product;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope(value = "session")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/", to = "/layout.jsf")
public class ProductController {

    private Product product = new Product();

    private String operation = "Add Record";

    @Autowired
    private ProductDAO productDAO;

    public String getOperation() {
        return operation;
    }

    private List<Product> productList = new ArrayList<>();

    public Product getProduct() {
        operation = "Update Record";
        return product;
    }

    public Product getProduct(Product product) {
        System.out.println(product.getProductName());
        operation = "Update Record";
        return product;
    }

    public List<Product> getProductList() {
        productList = productDAO.getAllProducts();
        return productList;
    }

    public void saveProduct()
    {
        productDAO.saveOrUpdateProduct(product);
        product = new Product();
        productList = getProductList();
        operation = "Add Record";
    }

    public void updateProduct()
    {
        productDAO.saveOrUpdateProduct(product);
        product = new Product();
        productList = getProductList();
        operation = "Add Record";
    }

    public void deleteProduct(Product product)
    {
        productDAO.deleteProductById(product.getProductId());
        productList = getProductList();
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

}
