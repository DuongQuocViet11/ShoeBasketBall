package com.shoebasketball.shoebasketball.controller.admin.product;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.entity.myenum.ProductStatus;
import com.shoebasketball.shoebasketball.model.CategoryModel;
import com.shoebasketball.shoebasketball.model.MySqlCategoryModel;
import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("categories", categoryModel.findAll());
        req.setAttribute("obj", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
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

        if(!product.isValid()){
            req.setAttribute("categories", categoryModel.findAll());
            req.setAttribute("obj", product);
            req.setAttribute("action", 1);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        if (productModel.save(product) != null) {
            resp.sendRedirect("/admin/products/list");
        } else {
            req.setAttribute("categories", categoryModel.findAll());
            req.setAttribute("obj", product);
            req.setAttribute("action", 1);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }
}
