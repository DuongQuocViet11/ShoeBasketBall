package com.shoebasketball.shoebasketball.controller.admin.product;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DeleteProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findbyId(id);
        if (product == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            boolean result = productModel.delete(id);
            if (result){
                resp.sendRedirect("/admin/products/list");
            }else {
                req.setAttribute("message", "Action fails");
                req.getRequestDispatcher("/admin/errors/505.jsp").forward(req, resp);
            }
        }
    }
}
