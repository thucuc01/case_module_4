package com.cg.teddyamazing.service.role.impl;

import com.cg.teddyamazing.model.account.Role;
import com.cg.teddyamazing.repository.role.RoleRepo;
import com.cg.teddyamazing.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Iterable<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role save(Role model) {
        return roleRepo.save(model);
    }

    @Override
    public void delete(Role model) {
        roleRepo.delete(model);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }
}
