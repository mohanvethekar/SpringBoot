package com.crud.crudoperations.service;

import com.crud.crudoperations.entity.Product;
import com.crud.crudoperations.repository.ProductRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Data
@Service
@Getter
@Setter
public class ProductService {

    @Autowired

    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product_removed" + id ;
    }
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(product);
      existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
