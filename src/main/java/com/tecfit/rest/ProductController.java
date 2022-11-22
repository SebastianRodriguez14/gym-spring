package com.tecfit.rest;

import com.tecfit.model.Product;
import com.tecfit.model.Trainer;
import com.tecfit.service.FileService;
import com.tecfit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;

    @GetMapping("/all")
    public Collection<Product>findAll(){
        return productService.findAll();
    }

    @PostMapping("/post")
    public Product add(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
        Product product = new Product();
        product = productService.findById(id);
        if(product != null){
            fileService.deleteFile(product.getImage().getId_file());
            productService.delete(id);
            return  new ResponseEntity<>("Product Removed", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
