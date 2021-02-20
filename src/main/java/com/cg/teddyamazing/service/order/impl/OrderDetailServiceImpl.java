package com.cg.teddyamazing.service.order.impl;

import com.cg.teddyamazing.model.order.OrderDetail;
import com.cg.teddyamazing.repository.oder.OrderDetailRepo;
import com.cg.teddyamazing.service.order.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    public OrderDetailRepo orderDetailRepo;
    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepo.findAll();
    }

    @Override
    public OrderDetail findById(Long id) {
        return orderDetailRepo.findById(id).get();
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepo.delete(findById(id));
    }

    @Override
    public List<OrderDetail> findByOder_Id(Long id) {
        return orderDetailRepo.findByOder_Id(id);
    }

    @Override
    public OrderDetail findByProduct_Id(String id) {
        return orderDetailRepo.findByProduct_Id(id);
    }
}
