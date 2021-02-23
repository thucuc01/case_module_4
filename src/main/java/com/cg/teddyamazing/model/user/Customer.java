package com.cg.teddyamazing.model.user;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "please input your first name")
    private String firstName;
    @NotEmpty(message = "pease input your last name")
    private String lastName;
    @NotEmpty(message = "pease input your address")
    private String address;

    @Column(unique = true)
    @NotEmpty(message = "pease input your phone number")
    @Pattern(regexp = "^[0][0-9]{9}$",message = "sdt star 0, 0-9, size=10")
    private String phoneNumber;
    @OneToOne
    @JoinColumn
    private Account account;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String phoneNumber,Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Customer(Long id, @NotEmpty(message = "please input your first name") String firstName, @NotEmpty(message = "pease input your last name") String lastName, @NotEmpty(message = "pease input your address") String address, @NotEmpty(message = "pease input your phone number") String phoneNumber, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}