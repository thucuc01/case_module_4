package com.cg.teddyamazing.model.product;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class ManageProducts {
    @Id
    private String id;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date date_Added;
    private Date nsx;
    private Date hsd;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public ManageProducts() {
    }

    public ManageProducts(String id, Date date_Added, Date nsx, Date hsd, int quantity, Product product) {
        this.id = id;
        this.date_Added = date_Added;
        this.nsx = nsx;
        this.hsd = hsd;
        this.quantity = quantity;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate_Added() {
        return date_Added;
    }

    public void setDate_Added(Date date_Added) {
        this.date_Added = date_Added;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
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
}
