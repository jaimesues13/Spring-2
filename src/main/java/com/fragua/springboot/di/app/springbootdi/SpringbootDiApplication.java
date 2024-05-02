package com.fragua.springboot.di.app.springbootdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fragua.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.fragua.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@SpringBootApplication
public class SpringbootDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDiApplication.class, args);
	}

	/* 
    @Bean
	@Primary
    ProductRepository productRepositoryJson(){
		return new ProductRepositoryJson();
	}
*/
}
