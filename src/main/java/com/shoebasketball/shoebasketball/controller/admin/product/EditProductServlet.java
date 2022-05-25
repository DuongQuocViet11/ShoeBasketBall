package com.shoebasketball.shoebasketball.controller.admin.product;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.entity.myenum.ProductStatus;
import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {
    private ProductModel productModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findbyId(id);
        if (product == null){
            req.setAttribute("Message", "Customer not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("obj", product);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct = productModel.findbyId(id);
        if(existingProduct == null){
            req.setAttribute("message", "Product not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            String name = req.getParameter("name");
            int categoryId = Integer.parseInt( req.getParameter("categoryId"));
            int status = Integer.parseInt( req.getParameter("status"));
            String description = req.getParameter("description");
            String detail = req.getParameter("detail");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            Product product = new Product();
            product.setName(name);
            product.setCategoryId(categoryId);
            product.setStatus(ProductStatus.of(status));
            product.setDescription(description);
            product.setDetail(detail);
            product.setThumbnail(thumbnail);
            product.setPrice(price);

            if (productModel.update(id, product) != null){
                resp.sendRedirect("/admin/products/list");
            }else {
                req.setAttribute("obj", product);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }
        }
    }
}
