package com.dglazewski.mvcdg.controller;

import com.dglazewski.mvcdg.model.Product;
import com.dglazewski.mvcdg.model.ProductDto;
import com.dglazewski.mvcdg.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get all products")
    @GetMapping(value = "/all")
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get all bought products")
    @GetMapping("/bought")
    public List<Product> boughtProducts() {
        return productService.getBoughtProducts();
    }


    @Operation(summary = "Get all not bought products")
    @GetMapping("/notBought")
    public List<Product> notBoughtProducts() {
        return productService.getNotBoughtProducts();
    }

    @Operation(summary = "Get product/products by name")
    @GetMapping
    public List<Product> product(@Parameter(description = "name of product")
                                 @RequestParam String name) {
        return productService.getProduct(name);
    }

    @Operation(summary = "Add product")
    @PostMapping
    public boolean addProduct(@Parameter(description = "Model of product to be added")
                              @RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping
    public void deleteProduct(@Parameter(description = "Id of product to be deleted")
                              @RequestParam int id) {
        productService.deleteProduct(id);
    }


    @Operation(summary = "Update product")
    @PutMapping
    public Product updateProduct(@Parameter(description = "Model of new product to be updated")
                                 @RequestBody ProductDto productDto,
                                 @Parameter(description = "Id of old product")
                                 @RequestParam int productId) {
        return productService.updateProduct(productId, productDto);
    }
}
