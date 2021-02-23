package com.cg.teddyamazing.controller.product;

import com.cg.teddyamazing.model.product.*;

import com.cg.teddyamazing.service.product.ManagerProductService;
import com.cg.teddyamazing.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/quanly")
public class ManagerController {
    @Autowired
    public ManagerProductService managerProductService;
    @Autowired
    public ProductService productService;

    @ModelAttribute("products")
    public Iterable<Product> products(){
        return productService.findAll();
    }


    @GetMapping("/create_manager")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("manager_product/create");
        modelAndView.addObject("manageProduct", new ManageProducts());
        return modelAndView;
    }
    @PostMapping("/create-Mproduct")
    public ModelAndView createManagerProduct(@Valid @ModelAttribute ("manageProduct") ManageProducts manageProduct, BindingResult bindingResult){
        ModelAndView modelAndView;

            if(bindingResult.hasFieldErrors()){
                modelAndView=new ModelAndView("manager_product/create");
                return modelAndView;
            }
            managerProductService.save(manageProduct);

            modelAndView = new ModelAndView("manager_product/create");
            modelAndView.addObject("managerProduct", new ManageProducts());
            modelAndView.addObject("message", "Product updated successfully");

        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showHome(
            @RequestParam("s") Optional<String> s,
            @RequestParam("s1") Optional<String> s1,
            @RequestParam("page") Optional<Integer> page,
            Pageable pageable){
        Page<ManageProducts> manageProducts;

        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        pageable = PageRequest.of(pageNum, 10);
        manageProducts = managerProductService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("manager_product/list");
        modelAndView.addObject("manageproducts", manageProducts);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        managerProductService.remove(id);
        return "redirect:/quanly/show";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable String id){
        ManageProducts manageProducts=managerProductService.findById(id);
        ModelAndView modelAndView=new ModelAndView("manager_product/edit","manageProducts",manageProducts);
        return modelAndView;
    }


}