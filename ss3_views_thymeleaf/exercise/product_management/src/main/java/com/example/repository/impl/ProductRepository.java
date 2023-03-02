package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    public static List<Product> productList;
    static {
        productList = new ArrayList<Product>() {{
            add(new Product(1, "Đồng hồ", 350000, "second hand", "TQ"));
            add(new Product(2, "Laptop", 12000000, "ultra vip", "US"));
            add(new Product(3, "Tủ lạnh", 550000, "vip", "UK"));
        }};
    }
    @Override
    public List<Product> listProductByName(String name) {
        if (name == null) {
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
               products.add(product);
            }
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        product.setId(productList.size()+1);
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                value.setName(product.getName());
                value.setPrice(product.getPrice());
                value.setDescription(product.getDescription());
                value.setManufacturer(product.getManufacturer());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(findById(id));
    }
}
