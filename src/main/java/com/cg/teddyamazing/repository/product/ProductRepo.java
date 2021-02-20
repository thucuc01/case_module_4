package com.cg.teddyamazing.repository.product;

import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, String> {

    Iterable<Product> findAllByCategory(Category province);


    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}