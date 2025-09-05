package service;

import model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Galaxy Z Flip7", 1000, "Điện thoại", "SAMSUNG"));
        products.put(2, new Product(2, "Galaxy Watch8 Classic", 450, "Đồng hồ", "SONY"));
        products.put(3, new Product(3, "Asus x515", 940, "Máy tính", "ASUS"));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }
}
