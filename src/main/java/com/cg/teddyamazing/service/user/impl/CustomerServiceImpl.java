package com.cg.teddyamazing.service.user.impl;

import com.cg.teddyamazing.model.user.Customer;
import com.cg.teddyamazing.repository.user.CustomerRepo;
import com.cg.teddyamazing.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerRepo customerRepo;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return customerRepo.findAllByFirstNameContaining(firstName,pageable);
    }
}