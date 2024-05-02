package com.fragua.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fragua.springboot.di.app.springbootdi.models.Product;
import com.fragua.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Value("${config.value.imp}")
    private Double impuesto;

    @Autowired
    private Environment environment;

    private ProductRepository repository;

    public ProductServiceImpl(/*@Qualifier("repositoryUno")*/ ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double iva = environment.getProperty("config.value.imp", Double.class);
            Double imp =  p.getPrice() * impuesto;
            //Product newProduct = new Product(p.getId(), p.getName(), imp.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(imp.longValue());
            return newProduct;
            // p.setPrice(imp.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
