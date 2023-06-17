package com.dglazewski.mvcdg.service;

import com.dglazewski.mvcdg.model.ListProducts;
import com.dglazewski.mvcdg.model.Product;
import com.dglazewski.mvcdg.model.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ListProducts products;

    public List<Product> getAllProducts() {
        return products.getProducts();
    }

    public List<Product> getBoughtProducts() {
        return products.getProducts()
                .stream()
                .filter(Product::isBought)
                .collect(Collectors.toList());
    }

    public List<Product> getNotBoughtProducts() {
        return products.getProducts()
                .stream()
                .filter(product -> !product.isBought())
                .collect(Collectors.toList());
    }

    public List<Product> getProduct(String name) {
        return products.getProducts()
                .stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }

    public boolean addProduct(ProductDto productDto) {
        int size = products.getProducts().size();
        int id = size == 0 ? 1 : products.getProducts().get(size - 1).getId() + 1;
        Product product = new Product(productDto.getName(), productDto.isBought(), id);
        return products.getProducts().add(product);
    }

    public void deleteProduct(int id) {
        products = new ListProducts(products.getProducts()
                .stream()
                .filter(product1 -> product1.getId() != id)
                .collect(Collectors.toList()));
    }

    public Product updateProduct(int productId, ProductDto productDto) {
        for (int i = 0; i < products.getProducts().size(); i++) {
            if (products.getProducts().get(i).getId() == productId) {
                return products.getProducts().set(i, Product.of(productDto, productId));
            }
        }
        return null;
    }

    public boolean addProducts(List<ProductDto> productDtoList) {
        List<Product> list = new ArrayList<>();
        int iterator = 1;
        for (ProductDto productDto : productDtoList) {
            list.add(new Product(productDto.getName(), productDto.isBought(), iterator));
            iterator++;
        }
        products = new ListProducts(list);
        return true;
    }
}
