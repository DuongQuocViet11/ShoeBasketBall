package com.shoebasketball.shoebasketball.entity;

import com.shoebasketball.shoebasketball.ulti.DateTimeHelper;

import java.time.LocalDateTime;

public class Product {
    private String productId;
    private String name;
    private double price;
    private String thumbnail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Product(String productId, String name, double price, String thumbnail, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreate_At() {
        if(this.createdAt != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.createdAt);
        }
        return "";
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", thumbnail='" + thumbnail + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }
}
