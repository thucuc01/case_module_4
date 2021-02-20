package com.cg.teddyamazing.repository.product;


import com.cg.teddyamazing.model.product.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, String> {
}