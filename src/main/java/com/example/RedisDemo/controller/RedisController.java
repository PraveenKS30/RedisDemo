package com.example.RedisDemo.controller;

import com.example.RedisDemo.dao.Product;
import com.example.RedisDemo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class RedisController {

    @Autowired
    private ProductServices productServices;


    @PostMapping
    public Product save (@RequestBody Product product){
        return productServices.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productServices.findAll();
    }




}
