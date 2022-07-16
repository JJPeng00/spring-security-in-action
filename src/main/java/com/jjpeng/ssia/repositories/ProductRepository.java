package com.jjpeng.ssia.repositories;

import com.jjpeng.ssia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JJPeng
 * @date 2022/7/16 23:09
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
