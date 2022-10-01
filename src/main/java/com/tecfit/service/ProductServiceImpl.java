package com.tecfit.service;

import com.tecfit.model.Product;
import com.tecfit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Collection<Product> findAll(){
        return productRepository.findAll();
    }
}
