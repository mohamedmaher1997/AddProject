package com.primefaces.demo.service;

import com.primefaces.demo.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public Product getProductById(Integer id) {
        return entityManager.find(Product.class,id);
    }

    public Product save(Product product) {
        if(product!=null)
        {
            entityManager.persist(product);
            return product;
        }else {
            throw new RuntimeException("Product can not be null");
        }
    }

    public Product update(Product product) {
        if(product!=null)
        {
            if(product.getProductId()==null)
            {
                entityManager.persist(product);
            }else{
                entityManager.merge(product);
            }
            return product;
        }else {
            throw new RuntimeException("Product can not be null");
        }
    }

    public Integer deleteProductById(Integer productId) {
        if(productId!=null)
        {
            Product product = entityManager.find(Product.class,productId);
            entityManager.remove(product);
            return 1;
        }
        return -1;
    }

    public List<Product> getAllProducts() {
        Query query = entityManager.createNamedQuery("query_find_all_products",Product.class);
        return new ArrayList<>(query.getResultList());
    }

}
