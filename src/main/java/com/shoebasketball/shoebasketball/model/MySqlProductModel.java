package com.shoebasketball.shoebasketball.model;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel{
    @Override
    public Product save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="insert into products" +
                    "(productId, name, price, thumbnail, createdAt, updatedAt, status)" +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getThumbnail());
            preparedStatement.setString(5, product.getCreatedAt().toString());
            preparedStatement.setString(6, product.getUpdatedAt().toString());
            preparedStatement.setInt(7, product.getStatus());
            System.out.println("Connection success");
            preparedStatement.execute();
            return product;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId = resultSet.getString("productId");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String thumbnail = resultSet.getString("thumbnail");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Product product = new Product(productId, name, price, thumbnail, createdAt, updatedAt, status);
                list.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findbyId(String productId) {
        Product product = null;
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ? and productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String thumbnail = resultSet.getString("thumbnail");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                product = new Product(productId, name, price, thumbnail, createdAt, updatedAt, status);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product edit(String productId, Product updateProduct) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  products " +
                    "set productId = ?, name = ?, price = ?, thumbnail = ?, createdAt = ?, updatedAt = ?, status = ? where productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateProduct.getProductId());
            preparedStatement.setString(2, updateProduct.getName());
            preparedStatement.setDouble(3, updateProduct.getPrice());
            preparedStatement.setString(4, updateProduct.getThumbnail());
            preparedStatement.setString(5, updateProduct.getCreatedAt().toString());
            preparedStatement.setString(6, updateProduct.getUpdatedAt().toString());
            preparedStatement.setInt(7, updateProduct.getStatus());
            preparedStatement.setString(8, productId);
            System.out.println("Connection success");
            preparedStatement.execute();
            return updateProduct;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String productId) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  products " +
                    "set status = ? where productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, productId);
            System.out.println("Connection success");
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
