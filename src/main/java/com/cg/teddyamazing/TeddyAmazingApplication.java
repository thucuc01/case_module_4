package com.cg.teddyamazing;

import com.cg.teddyamazing.model.account.Account;
import com.cg.teddyamazing.model.account.Role;
import com.cg.teddyamazing.service.account.AccountService;
import com.cg.teddyamazing.service.account.impl.AccountServiceImpl;
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
import com.cg.teddyamazing.service.role.RoleService;
import com.cg.teddyamazing.service.role.impl.RoleServiceImpl;
import com.cg.teddyamazing.service.user.CustomerService;
import com.cg.teddyamazing.service.user.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class TeddyAmazingApplication {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        //region create roles
        List<Role> roles = (List<Role>)roleService.findAll();
        if(roles.isEmpty()){
            Role roleAdmin = new Role();
            roleAdmin.setRoleName("ROLE_ADMIN");
            roleService.save(roleAdmin);

            Role roleUser = new Role();
            roleUser.setRoleName("ROLE_USER");
            roleService.save(roleUser);
        }
        //endregion
        //region create list account
        List<Account> accounts = (List<Account>) accountService.findAll();
        if(accounts.isEmpty()){
            Account admin = new Account();
            admin.setUserName("admin");
            admin.setPassWord(passwordEncoder.encode("123"));
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setRoleName("ROLE_ADMIN");
            admin.setRole(roleAdmin);
            accountService.save(admin);

            Account user = new Account();
            user.setUserName("user");
            user.setPassWord(passwordEncoder.encode("12345"));
            Role roleUser = new Role();
            roleUser.setId(2L);
            roleUser.setRoleName("ROLE_USER");
            user.setRole(roleUser);
            accountService.save(user);
        }
        //endregion
    }

    public static void main(String[] args) {
        SpringApplication.run(TeddyAmazingApplication.class, args);
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }

    @Bean
    public SizeService sizeService() {
        return new SizeServiceImpl();
    }

    @Bean
    public ManagerProductService managerProductService() {
        return new ManagerServiceImpl();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public OderService oderService() {
        return new OderServiceImpl();
    }

    @Bean
    public OrderDetailService orderDetailService() {
        return new OrderDetailServiceImpl();
    }

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl();
    }

}