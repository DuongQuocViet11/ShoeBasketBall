package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product product);

    List<Product> findAll();

    Product findbyId(int id);

    Product update(int id, Product updateObj);

    boolean delete(int id);
}
