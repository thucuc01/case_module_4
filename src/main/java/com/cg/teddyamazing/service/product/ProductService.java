package com.cg.teddyamazing.service.product;

import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Iterable<Product> findAll();
//    Page<Product> findAll(Integer pageNo, Integer pageSize, String sortBy);

    Product findById(String id);

    void save(Product product);

    void remove(String id);

    Iterable<Product> findAllByCategory(Category province);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);



}