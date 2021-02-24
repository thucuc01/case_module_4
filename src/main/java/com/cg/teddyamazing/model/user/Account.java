//package com.cg.teddyamazing.model.user;
//
//import com.cg.teddyamazing.model.product.Category;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotEmpty
//    private String userName;
//    @NotEmpty
//    private String passWord;
//    private Date createDate;
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles;
//    public Account() {
//    }
//
//    public Account(String userName,String passWord, Date createDate, Set<Role> roles) {
//        this.userName = userName;
//        this.passWord = passWord;
//        this.createDate = createDate;
//        this.roles = roles;
//    }
//
//    public Account(Long id, @NotEmpty String userName, @NotEmpty String passWord, Date createDate, Set<Role> roles) {
//        this.id = id;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.createDate = createDate;
//        this.roles = roles;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassWord() {
//        return passWord;
//    }
//
//    public void setPassWord(String passWord) {
//        this.passWord = passWord;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//}
