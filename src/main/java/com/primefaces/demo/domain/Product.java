package com.primefaces.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
@NamedQuery(query = "select p from Product p", name = "query_find_all_products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Integer quantity;

    public Product(){}

    public Product(Integer productId, String productName, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
