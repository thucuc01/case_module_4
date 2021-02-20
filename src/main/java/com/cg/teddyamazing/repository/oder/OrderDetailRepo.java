package com.cg.teddyamazing.repository.oder;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.order.OrderDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail,Long> {

    List<OrderDetail> findByOder_Id(Long id);
    OrderDetail findByProduct_Id(String id);

}
