package com.cg.teddyamazing.repository.product;


import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import com.cg.teddyamazing.model.product.ProductWeb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ManagerProductRepo extends PagingAndSortingRepository<ManageProducts, String> {
    List<ManageProducts> findByProduct_Id(String id);

    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id where product.category_id=:id group by product_id;")
    List<ProductWeb> findAllByProduct_Category_Id(String id);

    List<ManageProducts> findAllByProduct_Size_Id(String id);

    Optional<ManageProducts> findById(String id);

    Iterable<ManageProducts> findAllByProduct(Product product);



    @Query(nativeQuery = true,value ="select * from manage_products where product_id=:id order by hsd;")
    List<ManageProducts> findAllByProductSort(String id);

    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id \n" +
            "where product.category_id=:id and product_id<>:id1\n" +
            "group by product_id limit 4;")
    List<ProductWeb> findAllByCategoryLimit(String id,String id1);
    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id group by product_id;")
    List<ProductWeb> findAllGroupBy();

    //sort_by_name
    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id group by product_id ORDER BY product.name ASC;")
    List<ProductWeb> findAllOderByName();

    //sort_by_price
    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id group by product_id ORDER BY product.price ASC;")
    List<ProductWeb> findAllOderByPrice();


    //test: tim kiem
    @Query(nativeQuery = true,value ="select product_id,product.name as p_name,product.desv as p_desv,product.price as p_price,product.img as p_img, product.category_id as p_category,product.size_id as p_size,sum(quantity) as quantity from manage_products inner join product on manage_products.product_id=product.id where product.name like :name group by product_id;")
    List<ProductWeb> findAllFindByName(@Param("name") String name);

}
