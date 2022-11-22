package com.tecfit.rest;

import com.tecfit.model.Product;
import com.tecfit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public Collection<Product>findAll(){
        return productService.findAll();
    }

    @PostMapping("/post")
    public Product add(@RequestBody Product product){
        return productService.save(product);
    }
}
