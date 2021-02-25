package com.cg.teddyamazing.controller.account;

import com.cg.teddyamazing.model.account.Account;
import com.cg.teddyamazing.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ModelAndView showAccount(){
        Iterable<Account> listAccount = accountService.findAll();
        return new ModelAndView("account/list_account","listAccount",listAccount);
    }
}
