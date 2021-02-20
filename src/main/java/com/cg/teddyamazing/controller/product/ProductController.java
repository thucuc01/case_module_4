package com.cg.teddyamazing.controller.product;


import com.cg.teddyamazing.model.product.*;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ManagerProductService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @Autowired
    public ProductService productService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    public ManagerProductService managerProductService;

    @ModelAttribute("sizes")
    public Iterable<Size> sizes(){
        return sizeService.findAll();
    }


    @GetMapping("/home")
    public ModelAndView showHome(@RequestParam("s") Optional<String> s,
                                 @RequestParam("s1") Optional<String> s1,
                                 @RequestParam("page") Optional<Integer> page,
                                 Pageable pageable){
        Page<Product> products;
        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        Sort sort = Sort.by("name");
        if(s.isPresent()){
            pageable = PageRequest.of(pageNum, 10);
            products = productService.findAllByNameContaining(s.get(), pageable);
        } else {
            if(s1.isPresent()){
                pageable = PageRequest.of(pageNum, 10, sort);
                products=productService.findAll(pageable);
            }else {
                pageable = PageRequest.of(pageNum, 10);
                products = productService.findAll(pageable);
            }
        }

        for (Product p :
                products) {
            System.out.println(p.getImg());
        }
        System.out.println();
        ModelAndView modelAndView = new ModelAndView("product/home");
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.remove(id);
        return "redirect:/home";
    }

    @Value("${upload.path}")
    private String fileUpload;


    @PostMapping("/create-product")
    public ModelAndView createProduct(@Valid @ModelAttribute("product") ProductForm product, BindingResult bindingResult,Pageable pageable){
        ModelAndView modelAndView;

        Page<Product> products=productService.findAll(pageable);

        for (Product p :
                products) {
            if (p.getId().equals(product.getId())){
                modelAndView = new ModelAndView("product/add");
                modelAndView.addObject("product", new Product());
                modelAndView.addObject("message", "ID da ton tai");
                return modelAndView;
            }
        }

        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("product/add");
            return modelAndView;
        }
        Product product1;
        product1= new Product.ProductBuilder(product.getName()).desv(product.getDesv()).build();
        MultipartFile multipartFile;
        multipartFile= product.getImg();
        String fileName;
        fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getImg().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDesv(product.getDesv());
        product1.setCategory(product.getCategory());
        product1.setSize(product.getSize());
        product1.setImg(fileName);
        productService.save(product1);
        modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successfully");

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("web/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/save-product")
    public ModelAndView editProduct (@Valid @ModelAttribute("product") ProductForm product,BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("product/edit");
            return modelAndView;
        }
        Product product1 = new Product.ProductBuilder(product.getName())
                .desv(product.getDesv()).build();
        MultipartFile multipartFile = product.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getImg().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDesv(product.getDesv());
        product1.setCategory(product.getCategory());
        product1.setSize(product.getSize());
        product1.setImg(fileName);
        productService.save(product1);
        modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }
    @GetMapping("/info/{id}")
    public ModelAndView showInfo(@PathVariable String id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/info");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }


}