package com.fragua.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fragua.springboot.di.app.springbootdi.models.Product;

//@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "otro producto", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "otro producto", 600L);
    }
    

}
