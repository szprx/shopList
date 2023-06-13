package com.dglazewski.mvcdg.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Product {
    private String name;
    private boolean bought;
    private int id;

    public static Product of(ProductDto productDto, int id){
        return  Product.builder()
                .name(productDto.getName())
                .bought(productDto.isBought())
                .id(id)
                .build();
    }

}
