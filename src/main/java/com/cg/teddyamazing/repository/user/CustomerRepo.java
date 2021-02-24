package com.cg.teddyamazing.repository.user;

import com.cg.teddyamazing.model.user.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
    Customer findByPhoneNumber(String phone);

}