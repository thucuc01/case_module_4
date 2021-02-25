package com.cg.teddyamazing.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    @GetMapping("/admin")
    public String webHomeDemo(){
        return "admin/home-demo";
    }
    @GetMapping("/user")
    public String webUserDemo(){
        return "user/user-demo";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "denied";
    }
}
