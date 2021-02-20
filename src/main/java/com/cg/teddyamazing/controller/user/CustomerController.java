//package com.cg.teddyamazing.controller.user;
//
//import com.cg.teddyamazing.model.user.Customer;
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
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
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
//    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Pageable pageable){
//        ModelAndView modelAndView;
//
//        Page<Customer> customers = customerService.findAll(pageable);
//
//        for (Customer c :customers){
//            if (c.getId().equals(customer.getId())){
//                modelAndView = new ModelAndView("customer/create");
//                modelAndView.addObject("customer",new Customer());
//                modelAndView.addObject("message","ID da ton tai");
//                return modelAndView;
//            }
//        }
//
//        if (bindingResult.hasFieldErrors()){
//            modelAndView = new ModelAndView("customer/create");
//            return modelAndView;
//        }
//
//        customerService.save(customer);
//        modelAndView = new ModelAndView("customer/create");
//        modelAndView.addObject("customer",new Customer());
//        modelAndView.addObject("message", "da them khach hang thanh cong");
//        return modelAndView;
//    }
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