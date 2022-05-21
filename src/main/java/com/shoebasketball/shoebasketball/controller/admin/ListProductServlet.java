package com.shoebasketball.shoebasketball.controller.admin;

import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;

    private ListProductServlet(){
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listProduct", productModel.findAll());
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }

}
