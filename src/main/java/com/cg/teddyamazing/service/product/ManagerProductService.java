package com.cg.teddyamazing.service.product;


import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import com.cg.teddyamazing.model.product.ProductWeb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ManagerProductService {
    Page<ManageProducts> findAll(Pageable pageable);

    void save(ManageProducts manageProducts);

    void remove(String id);

    Iterable<ManageProducts> findAllByProduct(Product product);

    List<ProductWeb> findAllGroupBy();
    List<ProductWeb> findAllOderByName();
    List<ProductWeb> findAllOderByPrice();

    List<ProductWeb> findAllFindByName(@Param("name") String name);

    List<ManageProducts> findByProduct_Id(String id);

    ManageProducts findById(String id);

    List<ManageProducts> findAllByProductSort(String id);

    List<ProductWeb> findAllByProduct_Category_Id(String id);

    List<ProductWeb> findAllByCategoryLimit(String id,String id1);




}
