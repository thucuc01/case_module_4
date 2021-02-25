package com.cg.teddyamazing.controller.web;

import com.cg.teddyamazing.model.order.Oder;
import com.cg.teddyamazing.model.order.OderWeb;
import com.cg.teddyamazing.model.order.OrderDetail;
import com.cg.teddyamazing.model.product.*;
import com.cg.teddyamazing.model.user.Customer;
import com.cg.teddyamazing.service.order.OderService;
import com.cg.teddyamazing.service.order.OrderDetailService;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ManagerProductService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import com.cg.teddyamazing.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web")
public class WebController {
    @Autowired
    public ManagerProductService managerProductService;
    @Autowired
    public ProductService productService;


    @Autowired
    public CustomerService customerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OderService oderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }


    @Autowired
    private SizeService sizeService;


    @ModelAttribute("sizes")
    public Iterable<Size> sizes(){
        return sizeService.findAll();
    }

    @ModelAttribute("products")
    public Iterable<Product> products(){
        return productService.findAll();
    }

    @GetMapping
    public ModelAndView showList(@RequestParam("s") Optional<String> s,
                                 @RequestParam("s1") Optional<String> s1){
        List<ProductWeb> manageProducts;
        String name;
        if(s.isPresent()){
            name="%"+s.get()+"%";
            manageProducts = managerProductService.findAllFindByName(name);
        } else {
            if(s1.isPresent()){
                manageProducts=managerProductService.findAllOderByPrice();
            }else {
                manageProducts = managerProductService.findAllGroupBy();
            }
        }


        System.out.println();
        ModelAndView modelAndView = new ModelAndView("web/list");
        modelAndView.addObject("manageproducts", manageProducts);
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public ModelAndView showInfo(@PathVariable String id){
        Product product = productService.findById(id);
        if(product != null) {
            String id1=product.getCategory().getId();
            List<ProductWeb> productWebs= managerProductService.findAllByCategoryLimit(id1,id);
            ModelAndView modelAndView = new ModelAndView("web/info");
            modelAndView.addObject("product", product);
            modelAndView.addObject("productWebs", productWebs);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("web/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/create-order")
    public ModelAndView oderProduct(@ModelAttribute("product")Product product,
                                    @RequestParam("quantity") int quantity,
                                    // test ID customer:
                                    @RequestParam("customerId") Optional<Long> id,
                                    @RequestParam("imga") String img){
        product.setImg(img);
        ModelAndView modelAndView;
        product.getImg();
        List<ManageProducts> manageProducts=managerProductService.findByProduct_Id(product.getId());
        int sum_quantity=0;
        for (ManageProducts m :
                manageProducts) {
            sum_quantity=sum_quantity+m.getQuantity();
        }
        if(sum_quantity==0){
            modelAndView=new ModelAndView("web/info");
            modelAndView.addObject("product",product);
            modelAndView.addObject("message","San pham nay hien tai dang het hang");
            return modelAndView;
        }
        if(id.isPresent()){
            if(quantity<=0||quantity>sum_quantity){
                modelAndView=new ModelAndView("web/info");
                modelAndView.addObject("product",product);
                modelAndView.addObject("message","Ban chi co the mua tu 1 - "+sum_quantity+" san pham");
                return modelAndView;
            }

            Customer customer= customerService.findById(id.get());
            String status="pending";
            Oder oder=new Oder(status,customer);
            oderService.save(oder);
            OrderDetail orderDetail=new OrderDetail(quantity,product,oder);
            orderDetailService.save(orderDetail);
            modelAndView=new ModelAndView("web/info");
            modelAndView.addObject("product",product);
            modelAndView.addObject("message", "Them vao gio hang thanh cong");
            return modelAndView;
        }
        modelAndView=new ModelAndView("customer/create","customer",new Customer());
        return modelAndView;

    }

    @PostMapping("/oder")
    public ModelAndView showOder(@RequestParam("customerId") Optional<Long> id){
        ModelAndView modelAndView;
        if(id.isPresent()){
            List<OderWeb> list=oderService.findByCustomer_IdAndStatus(id.get());
            Long id2=id.get();
            modelAndView=new ModelAndView("web/order","list",list);
            modelAndView.addObject("id2",id2);
            return modelAndView;
        }
        modelAndView=new ModelAndView("web/list","message","ban chua co gio hang");
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView notBuyOder(@RequestParam("id") Long id,@RequestParam("id2") Long id1){
        Oder oder=oderService.findById(id);
        List<OrderDetail> list1=orderDetailService.findByOder_Id(id);

        for (OrderDetail o :
                list1) {
            orderDetailService.remove(id);
        }
        oderService.remove(id);
        ModelAndView modelAndView;
        Long id2=id1;
        List<OderWeb> list=oderService.findByCustomer_IdAndStatus(id1);
        modelAndView=new ModelAndView("web/order","list",list);
        modelAndView.addObject("message", "Xoa khoi gio hang thanh cong");

        modelAndView.addObject("id2",id2);
        return modelAndView;
    }

    @PostMapping("/accept")
    public ModelAndView buyProduct(@RequestParam("id") Long id,@RequestParam("id2") Long id1){
        Oder oder=oderService.findById(id);
        List<OrderDetail> list1=orderDetailService.findByOder_Id(id);
        ArrayList<Product> list2=new ArrayList<Product>();
        String id_product="";
        int quantity=0;
        int quantity2=0;
        for (OrderDetail o : list1) {
            quantity=o.getQuantity();
            id_product=o.getProduct().getId();
            Product product=productService.findById(id_product);
            list2.add(product);
        }
        List<ManageProducts> list3= managerProductService.findByProduct_Id(id_product);
        for (ManageProducts m : list3) {
            quantity2=quantity2+m.getQuantity();
        }
        ModelAndView modelAndView=new ModelAndView("web/order");
        Long id2;
        if(quantity>quantity2){
            id2=id1;
            List<OderWeb> list=oderService.findByCustomer_IdAndStatus(id1);
            modelAndView.addObject("list",list);
            modelAndView.addObject("id2",id2);
            return modelAndView;
        }
        oder.setStatus("accept");
        oderService.save(oder);
        List<ManageProducts> manageProductsList= managerProductService.findAllByProductSort(id_product);
        for (ManageProducts manageProducts:manageProductsList) {
            if(quantity<=manageProducts.getQuantity()){
                quantity=manageProducts.getQuantity()-quantity;
                manageProducts.setQuantity(quantity);
                managerProductService.save(manageProducts);
                id2=id1;
                List<OderWeb> list=oderService.findByCustomer_IdAndStatus(id1);
                modelAndView.addObject("list",list);
                modelAndView.addObject("id2",id2);
                return modelAndView;
            }
            quantity=quantity-manageProducts.getQuantity();
            manageProducts.setQuantity(0);
        }
        modelAndView.addObject("message", "Tao don hang thanh cong");
        return modelAndView;
    }

    @GetMapping("/list/{id}")
    public ModelAndView getListCategories(@PathVariable String id,@RequestParam("s") Optional<String> s,
                                          @RequestParam("s1") Optional<String> s1){
        ModelAndView modelAndView;


        List<ProductWeb> manageProducts;
        manageProducts= managerProductService.findAllByProduct_Category_Id(id);
        modelAndView=new ModelAndView("web/list");
        modelAndView.addObject("manageproducts",manageProducts);
        return modelAndView;
    }

    @PostMapping("/oderAccept")
    public ModelAndView getListOderAccept(@RequestParam("customerId") Optional<Long> id){
        ModelAndView modelAndView;
        if(id.isPresent()){
            List<OderWeb> list=oderService.findByCustomer_IdAndStatusAccept(id.get());
            Long id2=id.get();
            modelAndView=new ModelAndView("web/order-accept","list",list);
            modelAndView.addObject("id2",id2);
            return modelAndView;
        }
        modelAndView=new ModelAndView("web/list","message","chua co thong tin");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editOrder(@PathVariable Long id){

        Oder oder=oderService.findById(id);
        ModelAndView modelAndView=new ModelAndView("web/edit-order","oder",oder);
        return modelAndView;

    }


}
