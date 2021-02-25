package com.cg.teddyamazing.controller.account;

import com.cg.teddyamazing.model.account.Account;
import com.cg.teddyamazing.model.account.Role;

import com.cg.teddyamazing.model.user.Customer;
import com.cg.teddyamazing.service.account.AccountService;

import com.cg.teddyamazing.service.role.RoleService;
import com.cg.teddyamazing.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/register-login")
    public ModelAndView formRegisterLogin(){
        ModelAndView mav = new ModelAndView("account/form_register");
        Account account = new Account();
        Customer customer = new Customer();
        mav.addObject("account",account);
        mav.addObject("customer",customer);

        return mav;
    }


    @PostMapping("/register-login")
    public ModelAndView registerAccount(@ModelAttribute("account")Account account,
                                        @ModelAttribute("customer")Customer customer){
        ModelAndView mav = new ModelAndView("account/form_register");

        // give data account of user into DB
        customerService.save(customer);
        account.setCustomer(customer);
        account.setRole(new Role(2L));
        accountService.save(account);

        account = new Account();
        customer = new Customer();
        return mav;
    }
}
