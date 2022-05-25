package com.shoebasketball.shoebasketball.controller.admin.product;

import com.shoebasketball.shoebasketball.entity.Product;
import com.shoebasketball.shoebasketball.model.MySqlProductModel;
import com.shoebasketball.shoebasketball.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy tham số (cusID)
        int id = Integer.parseInt(req.getParameter("id"));
        //Kiểm tra xem trong database có tồn tại
        Product product = productModel.findbyId(id);
        //nếu không trả về trang 404
        if (product == null){
            req.setAttribute("Message", "Product not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }
}
