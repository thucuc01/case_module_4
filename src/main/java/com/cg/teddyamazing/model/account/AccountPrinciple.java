package com.cg.teddyamazing.model.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AccountPrinciple implements UserDetails {

    private Long id;
    private String userName;
    private String passWord;
    private Date createDate;

    private Collection<? extends GrantedAuthority> roles;

    public AccountPrinciple(Long id, String userName, String passWord, Date createDate, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.createDate = createDate;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails build(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        Role role = account.getRole();

        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

        return new AccountPrinciple(account.getId(),
                account.getUserName(), account.getPassWord(),
                account.getCreateDate(), authorities);
    }
}
