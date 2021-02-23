package com.cg.teddyamazing.service.user;

import com.cg.teddyamazing.model.user.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);



    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAll();

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);


}