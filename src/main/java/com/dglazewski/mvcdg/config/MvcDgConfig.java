package com.dglazewski.mvcdg.config;

import com.dglazewski.mvcdg.model.ListProducts;
import com.dglazewski.mvcdg.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MvcDgConfig {
    @Bean
    public ListProducts listProducts() {
        return new ListProducts(List.of(
                new Product("banan", false, 1),
                new Product("pomarańcza", false, 2),
                new Product("cytryna", true, 3),
                new Product("snickers", true, 4),
                new Product("woda", false, 5),
                new Product("czereśnie", true, 6),
                new Product("bułki", false, 7),
                new Product("kurczak", false, 8)
        ));
    }
}
