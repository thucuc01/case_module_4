package com.cg.teddyamazing.model.order;

public interface OderWeb {
    Long getOder_id();
    String getOder_status();
    Long getCustomer_id();
    int getQuantity();
    String getProduct_id();
    String getProduct_name();
    String getProduct_img();
    Double getProduct_price();
    default Double getMoney(){
        return getQuantity()*getProduct_price();
    }
}
