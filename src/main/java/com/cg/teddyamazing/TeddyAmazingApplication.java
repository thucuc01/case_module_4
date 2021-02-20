package com.cg.teddyamazing;

import com.cg.teddyamazing.service.order.OderService;
import com.cg.teddyamazing.service.order.OrderDetailService;
import com.cg.teddyamazing.service.order.impl.OderServiceImpl;
import com.cg.teddyamazing.service.order.impl.OrderDetailServiceImpl;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ManagerProductService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import com.cg.teddyamazing.service.product.impl.CategoryServiceImpl;
import com.cg.teddyamazing.service.product.impl.ManagerServiceImpl;
import com.cg.teddyamazing.service.product.impl.ProductServiceImpl;
import com.cg.teddyamazing.service.product.impl.SizeServiceImpl;
import com.cg.teddyamazing.service.user.CustomerService;
import com.cg.teddyamazing.service.user.impl.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeddyAmazingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeddyAmazingApplication.class, args);
    }
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }

    @Bean
    public SizeService sizeService(){
        return new SizeServiceImpl();
    }

    @Bean
    public ManagerProductService managerProductService(){
        return new ManagerServiceImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public OderService oderService(){
        return new OderServiceImpl();
    }
    @Bean
    public OrderDetailService orderDetailService(){
        return new OrderDetailServiceImpl();
    }

}