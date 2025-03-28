package com.tavant.hibernate.HibernateOneToOneMapping;

import com.tavant.hibernate.HibernateOneToOneMapping.dao.ProductDao;
import com.tavant.hibernate.HibernateOneToOneMapping.entity.Product;
import com.tavant.hibernate.HibernateOneToOneMapping.entity.ProductDetails;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Product product = new Product(1, "Laptop", 130000);
        ProductDetails pd = new ProductDetails(1, "Computers", "Dell");
        
        product.setDetails(pd);
        
        ProductDao dao = new ProductDao();
        dao.saveProduct(product);
    }
}
