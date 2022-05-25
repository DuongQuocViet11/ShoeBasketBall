package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {

    private ProductModel productModel;
    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    public void create(){
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("Nike Lebron XIII");
        product.setPrice(1000);
        product.setDescription("Lorem ipsum");
        product.setDetail("Lorem ipsum");
        product.setThumbnail("Lorem ipsum");
        productModel.save(product);
    }

    @Test
    public void findAll(){
        System.out.println(productModel.findAll().size());
    }

    @Test
    public void findById(){
        System.out.println(productModel.findbyId(1).toString());
    }
}