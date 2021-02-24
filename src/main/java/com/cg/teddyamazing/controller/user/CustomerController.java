//package com.cg.teddyamazing.controller.user;
//
//import com.cg.teddyamazing.model.user.Account;
//import com.cg.teddyamazing.model.user.Customer;
//import com.cg.teddyamazing.service.user.AccountService;
//import com.cg.teddyamazing.service.user.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
////@SessionAttributes("mycustomer")
//@RequestMapping("/customer")
//public class CustomerController {
//
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @GetMapping("/list")
//    public ModelAndView showList(@RequestParam("s") Optional<String> s,
//                                 @RequestParam("s1") Optional<String> s1,
//                                 @RequestParam("page") Optional<Integer> page,
//                                 Pageable pageable){
//        Page<Customer> customers;
//        int pageNumb = 0;
//        if (page.isPresent() && page.get() > 1){
//            pageNumb = page.get() -1;
//        }
//
//        Sort sort = Sort.by("firstName");
//        if(s.isPresent()){
//            pageable = PageRequest.of(pageNumb,8);
//            customers = customerService.findAllByFirstNameContaining(s.get(),pageable);
//        } else {
//            if (s1.isPresent()){
//                pageable = PageRequest.of(pageNumb, 8, sort);
//                customers = customerService.findAll(pageable);
//            } else {
//                pageable = PageRequest.of(pageNumb, 8);
//                customers = customerService.findAll(pageable);
//            }
//
//        }
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//
//    }
//
//    @PostMapping("/create-customer")
//    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, @RequestParam("account") Optional<Long> id){
//        ModelAndView modelAndView;
//        if (bindingResult.hasFieldErrors()){
//            modelAndView = new ModelAndView("customer/create");
//            return modelAndView;
//        }
//        modelAndView = new ModelAndView("customer/create");
//        if(id.isPresent()){
//            Account account = accountService.findById(id.get());
//            customer.setAccount(account);
//
//        }
//        customerService.save(customer);
//        modelAndView.addObject("customer",new Customer());
//        modelAndView.addObject("message", "da them khach hang thanh cong");
//        return modelAndView;
//
//    }
//
//
//    @GetMapping("/edit-customer/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Customer customer = customerService.findById(id);
//        if (customer != null){
//            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            modelAndView.addObject("customer",customer);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-customer")
//    public ModelAndView editCustomer (@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
//
//        ModelAndView modelAndView;
//        if(bindingResult.hasFieldErrors()){
//            modelAndView=new ModelAndView("customer/edit");
//            return modelAndView;
//        }
//
//        customerService.save(customer);
//
//        modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "Product updated successfully");
//        return modelAndView;
//    }
//
//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@RequestParam("id") Long id){
//        customerService.remove(id);
//        return "redirect:/customer/list";
//    }
//}
package com.cg.teddyamazing.controller.user;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.user.Customer;
import com.cg.teddyamazing.service.order.OderService;
import com.cg.teddyamazing.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
//@SessionAttributes("customer")
@RequestMapping("/customer")
public class CustomerController {

//    @ModelAttribute("customer")
//    public Customer setSession(){
//        return new Customer();
//    }
    @Autowired
    private CustomerService customerService;

    @GetMapping("/admin/list")
    public ModelAndView showList(@RequestParam("s") Optional<String> s,
                                 @RequestParam("s1") Optional<String> s1,
                                 @RequestParam("page") Optional<Integer> page,
                                 Pageable pageable){
        Page<Customer> customers;
        int pageNumb = 0;
        if (page.isPresent() && page.get() > 1){
            pageNumb = page.get() -1;
        }

        Sort sort = Sort.by("firstName");
        if(s.isPresent()){
            pageable = PageRequest.of(pageNumb,8);
            customers = customerService.findAllByFirstNameContaining(s.get(),pageable);
        } else {
            if (s1.isPresent()){
                pageable = PageRequest.of(pageNumb, 8, sort);
                customers = customerService.findAll(pageable);
            } else {
                pageable = PageRequest.of(pageNumb, 8);
                customers = customerService.findAll(pageable);
            }

        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;

    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, HttpSession httpSession){
        ModelAndView modelAndView;

        if (bindingResult.hasFieldErrors()){
            modelAndView = new ModelAndView("customer/create");
            return modelAndView;
        }

        customerService.save(customer);
        Customer customer1=customerService.findByPhoneNumber(customer.getPhoneNumber());
        httpSession.setAttribute("customer",customer1);
        modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message", "da them khach hang thanh cong");

        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView editCustomer (@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("customer/edit");
            return modelAndView;
        }
        customerService.save(customer);

        modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }
    @Autowired
    public OderService oderService;

    @PostMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("id") Long id, ModelAndView modelAndView){
        Iterable<Oder> oders= oderService.findAll();
        modelAndView=new ModelAndView("/customer/list");
        for (Oder c :
                oders) {
            if(c.getCustomer().getId()==id){
                modelAndView.addObject("message", "Khong the xoa do co hoa don order");
                return "redirect:/customer/list";
            }
        }
        customerService.remove(id);
        modelAndView.addObject("message", "Xoa thanh cong");
        return "redirect:/customer/list";

    }
}