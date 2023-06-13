package com.dglazewski.mvcdg.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDto {
    private String name;
    private boolean bought;
}
