package com.dglazewski.mvcdg.controller;

import com.dglazewski.mvcdg.model.Product;
import com.dglazewski.mvcdg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/bought")
    public List<Product> boughtProducts() {
        return productService.getBoughtProducts();
    }


    @GetMapping("/notBought")
    public List<Product> notBoughtProducts() {
        return productService.getNotBoughtProducts();
    }

    @GetMapping
    public List<Product> product(@RequestParam String name) {
        return productService.getProduct(name);
    }

    @PostMapping
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping
    public boolean deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }


    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
