package com.tecfit.service;

import com.tecfit.model.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> findAll();

    Product save(Product product);

    Product findById(Integer id);
    void delete(Integer id);

    Product putProduct(Product product);

}
