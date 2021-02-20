package com.cg.teddyamazing.repository.product;

import com.cg.teddyamazing.model.product.Size;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SizeRepo extends PagingAndSortingRepository<Size, String> {
}