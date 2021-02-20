package com.cg.teddyamazing.service.product.impl;

import com.cg.teddyamazing.model.product.Size;
import com.cg.teddyamazing.repository.product.SizeRepo;
import com.cg.teddyamazing.service.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;

public class SizeServiceImpl implements SizeService {

    @Autowired
    public SizeRepo sizeRepo;
    @Override
    public Iterable<Size> findAll() {
        return sizeRepo.findAll();
    }
}