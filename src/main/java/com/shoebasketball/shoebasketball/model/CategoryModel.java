package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Category;
import com.shoebasketball.shoebasketball.entity.Product;

import java.util.List;

public interface CategoryModel {
    Category save(Category obj);

    List<Category> findAll();

    Category findbyId(int id);

    Category update(int id, Category updateObj);

    boolean delete(int id);
}
