package com.cg.teddyamazing.repository.oder;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.order.OderWeb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OderRepo extends PagingAndSortingRepository<Oder,Long> {


    @Query(nativeQuery = true,value ="select oder.id as oder_id,oder.status as oder_status, oder.customer_id as customer_id,order_detail.quantity as quantity, order_detail.product_id as product_id, product.name as product_name,product.img as product_img, product.price as product_price from (oder join order_detail on oder.id=order_detail.oder_id) join product on order_detail.product_id=product.id where customer_id=:id and status='pending';")
    List<OderWeb> findByCustomer_IdAndStatus(@Param("id")Long id);

    @Query(nativeQuery = true,value ="select oder.id as oder_id,oder.status as oder_status, oder.customer_id as customer_id,order_detail.quantity as quantity, order_detail.product_id as product_id, product.name as product_name,product.img as product_img, product.price as product_price from (oder join order_detail on oder.id=order_detail.oder_id) join product on order_detail.product_id=product.id where customer_id=:id and status='accept';")
    List<OderWeb> findByCustomer_IdAndStatusAccept(@Param("id")Long id);

}
