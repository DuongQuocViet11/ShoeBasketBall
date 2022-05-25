package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {

    private MySqlCategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }

    @Test
    public void save(){
        Category category = new Category();
        category.setName("Nike");
        model.save(category);
        Category category2 = new Category();
        category2.setName("Adidas");
        model.save(category2);
        Category category3 = new Category();
        category3.setName("Under Armour");
        model.save(category3);
    }

    @Test
    public void update(){
        Category cate = model.findbyId(2);
        assertNotEquals(null, cate);
    }

    @Test
    public void delete(){
        model.delete(2);
    }
}