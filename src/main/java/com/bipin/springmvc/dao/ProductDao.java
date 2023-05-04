package com.bipin.springmvc.dao;

import com.bipin.springmvc.model.Product;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product)
    {
        this.hibernateTemplate.saveOrUpdate(product);
    }

    public List<Product> getAllProducts()
    {
        return this.hibernateTemplate.loadAll(Product.class);
    }

    @Transactional
    public void deleteProduct(int productId)
    {
        Product product= this.hibernateTemplate.load(Product.class, productId);
        this.hibernateTemplate.delete(product);;
    }

    public Product getProduct(int productId)
    {
        return this.hibernateTemplate.get(Product.class, productId);
    }
}
