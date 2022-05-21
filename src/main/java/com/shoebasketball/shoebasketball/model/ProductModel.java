package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product product);

    List<Product> findAll();

    Product findbyId(String productId);

    Product edit(String productId, Product updateProduct);

    boolean delete(String productId);
}
