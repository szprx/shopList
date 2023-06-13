package com.dglazewski.mvcdg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ListProducts {

    private List<Product> products;
}
