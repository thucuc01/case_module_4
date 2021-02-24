package com.cg.teddyamazing.service.order.impl;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.order.OderWeb;
import com.cg.teddyamazing.model.order.OrderDetail;
import com.cg.teddyamazing.repository.oder.OderRepo;
import com.cg.teddyamazing.service.order.OderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OderServiceImpl implements OderService {
    @Autowired
    public OderRepo oderRepo;

    @Override
    public Iterable<Oder> findAll() {
        return oderRepo.findAll();
    }

    @Override
    public Oder findById(Long id) {
        return oderRepo.findById(id).get();
    }

    @Override
    public void save(Oder oder) {
        oderRepo.save(oder);
    }

    @Override
    public void remove(Long id) {
        oderRepo.delete(findById(id));
    }

    @Override
    public List<OderWeb> findByCustomer_IdAndStatus(Long id) {
        return oderRepo.findByCustomer_IdAndStatus(id);
    }

    @Override
    public List<OderWeb> findByCustomer_IdAndStatusAccept(Long id) {
        return oderRepo.findByCustomer_IdAndStatusAccept(id);
    }
}
