package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                break;
        }
    }

    void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer price = Integer.valueOf(req.getParameter("price"));
        String description = req.getParameter("description");
        String nxb = req.getParameter("nxb");
        Product product = new Product(name, price, description, nxb);
        productService.addProduct(product);
        resp.sendRedirect("/products");
    }

    void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer price = Integer.valueOf(req.getParameter("price"));
        String description = req.getParameter("description");
        String nxb = req.getParameter("nxb");
        Product product = productService.getProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("product/error.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setNxb(nxb);
            this.productService.updateProduct(id, product);
        }
    }

    void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(id);
            resp.sendRedirect("/products?message=success!");
        } else {
            resp.sendRedirect("/products?error=id not exist!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(req, resp);
                break;
            case "update":
                showUpdateProduct(req, resp);
                break;
            case "delete":
                showDeleteProduct(req, resp);
                break;
            case "list":
                viewProduct(req, resp);
                break;
            default:
                showListProduct(req, resp);
                break;
        }
    }

    void showCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("product/error.jsp");
        } else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("update.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("product/error.jsp");
        } else {
            req.setAttribute("product", product);
        }
    }

    void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("product/error.jsp");
        } else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
