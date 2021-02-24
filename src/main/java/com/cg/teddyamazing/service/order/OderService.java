package com.cg.teddyamazing.service.order;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.order.OderWeb;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OderService {
    Iterable<Oder> findAll();

    Oder findById(Long id);

    void save(Oder oder);

    void remove(Long id);
    List<OderWeb> findByCustomer_IdAndStatus(Long id);

    List<OderWeb> findByCustomer_IdAndStatusAccept(Long id);


}
