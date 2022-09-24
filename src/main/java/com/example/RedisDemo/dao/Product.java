package com.example.RedisDemo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {
    private int id;
    private String name;
    private int qty;
    private long price;
}
