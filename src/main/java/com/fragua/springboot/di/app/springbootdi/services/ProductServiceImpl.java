package com.fragua.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fragua.springboot.di.app.springbootdi.models.Product;
import com.fragua.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double imp =  p.getPrice() * 1.16d;
            //Product newProduct = new Product(p.getId(), p.getName(), imp.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(imp.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
