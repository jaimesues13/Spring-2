package com.fragua.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fragua.springboot.di.app.springbootdi.models.Product;

//@Primary
@RequestScope
@Repository("repositoryUno")
public class ProductRepositoryImpl implements ProductRepository{

    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Producto uno", 300L),
            new Product(2L, "Producto dos", 200L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
    
}
