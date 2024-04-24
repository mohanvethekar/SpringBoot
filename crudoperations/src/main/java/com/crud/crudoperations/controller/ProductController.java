package com.crud.crudoperations.controller;

import com.crud.crudoperations.entity.Product;
import com.crud.crudoperations.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired


    private ProductService service;
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public Product addProducts(@RequestBody Product products){
        return service.saveProduct(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProduct();
    }
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")

    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(int id){
        return service.deleteProduct(id);
    }
}
