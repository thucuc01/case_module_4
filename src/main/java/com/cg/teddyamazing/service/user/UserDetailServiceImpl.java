//package com.cg.teddyamazing.service.user;
//
//import com.cg.teddyamazing.model.user.Account;
//import com.cg.teddyamazing.model.user.Role;
//import com.cg.teddyamazing.repository.user.AccountRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private AccountRepo userRepo;
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account user=userRepo.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
////        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////        Set<Role> roles = user.getRoles();
////        for (Role role : roles) {
////            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////
////        return new org.springframework.security.core.userdetails.User(
////                user.getEmail(), user.getPassword(), grantedAuthorities);
//
//        return null;
//    }
//}
