package com.shoebasketball.shoebasketball.entity;

import com.shoebasketball.shoebasketball.entity.base.BaseEntity;
import com.shoebasketball.shoebasketball.entity.myenum.CategoryStatus;
import com.shoebasketball.shoebasketball.entity.myenum.ProductStatus;
import com.shoebasketball.shoebasketball.ulti.DateTimeHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private String detail;
    private String thumbnail;
    private double price;
    private ProductStatus status;

    private HashMap<String, String> errors = new HashMap<>();

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate() {
        //validate dữ liệu theo kiểu cùi bắp
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (price == 0) {
            errors.put("price", "Please enter price");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (thumbnail == null || thumbnail.length() == 0){
            errors.put("thumbnail", "Please choose image");
        }
        if (detail == null || detail.length() == 0){
            errors.put("detail", "Please enter detail");
        }
    }

    public Product() {
        this.name = "";
        this.description = "";
        this.detail = "";
        this.price = 0;
        this.thumbnail = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
