package com.shoebasketball.shoebasketball.controller.admin.product;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;

    public ListProductServlet(){
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productModel.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
