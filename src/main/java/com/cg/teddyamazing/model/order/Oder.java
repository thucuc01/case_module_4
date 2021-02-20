package com.cg.teddyamazing.model.order;

import com.cg.teddyamazing.model.user.Customer;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @Column
    @CreationTimestamp
    private Date create_add;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public Oder() {
    }

    public Oder(Long id, String status, Date create_add, Customer customer) {
        this.id = id;
        this.status = status;
        this.create_add = create_add;
        this.customer = customer;
    }

    public Oder(String status, Customer customer) {
        this.status = status;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_add() {
        return create_add;
    }

    public void setCreate_add(Date create_add) {
        this.create_add = create_add;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
