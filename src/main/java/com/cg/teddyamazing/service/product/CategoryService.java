package com.cg.teddyamazing.service.product;

import com.cg.teddyamazing.model.product.Category;


public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(String id);

    void save(Category province);

    void remove(String id);
}