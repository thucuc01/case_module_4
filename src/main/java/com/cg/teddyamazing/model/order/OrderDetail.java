package com.cg.teddyamazing.model.order;

import com.cg.teddyamazing.model.product.Product;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn
    private Oder oder;

    public OrderDetail() {
    }

    public OrderDetail(Long id, int quantity, Product product, Oder oder) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.oder = oder;
    }

    public OrderDetail(int quantity, Product product, Oder oder) {
        this.quantity = quantity;
        this.product = product;
        this.oder = oder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }
}
