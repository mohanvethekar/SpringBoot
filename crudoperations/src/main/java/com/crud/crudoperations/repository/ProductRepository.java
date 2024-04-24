package com.crud.crudoperations.repository;

import com.crud.crudoperations.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName (String name);

}
