package com.dglazewski.mvcdg.service;

import com.dglazewski.mvcdg.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ArrayList<Product> products;


    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getBoughtProducts() {
        return products
                .stream()
                .filter(Product::isBought)
                .collect(Collectors.toList());
    }


    public List<Product> getNotBoughtProducts() {
        return products
                .stream()
                .filter(product -> !product.isBought())
                .collect(Collectors.toList());
    }


    public List<Product> getProduct(String name) {
        return products
                .stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }


    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean deleteProduct(Product product) {
        return products
                .removeIf(product1 -> product1.getName().equals(product.getName()));
    }

    public Product updateProduct(Product product) {
        int i = products.indexOf(product);
        return products.set(i,product);
    }
}
