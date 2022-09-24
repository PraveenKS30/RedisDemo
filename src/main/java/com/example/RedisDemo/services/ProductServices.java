package com.example.RedisDemo.services;

import com.example.RedisDemo.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private RedisTemplate template;

    public static final String HASH_KEY = "Product";


    //save object
    public Product save (Product product){
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    //get all objects
    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    //get object by id
    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    //delete object
    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "product removed!";
    }
}
