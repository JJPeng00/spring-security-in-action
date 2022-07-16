package com.jjpeng.ssia.service;

import com.jjpeng.ssia.model.Product;
import com.jjpeng.ssia.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JJPeng
 * @date 2022/7/16 23:11
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
