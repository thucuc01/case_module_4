package com.cg.teddyamazing.service.order;

import com.cg.teddyamazing.model.order.OrderDetail;
import com.cg.teddyamazing.model.product.Category;

import java.util.List;

public interface OrderDetailService {
    Iterable<OrderDetail> findAll();

    OrderDetail findById(Long id);

    void save(OrderDetail orderDetail);

    void remove(Long id);

    List<OrderDetail> findByOder_Id(Long id);

    OrderDetail findByProduct_Id(String id);


}
