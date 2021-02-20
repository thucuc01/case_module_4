package com.cg.teddyamazing.repository.user;

import com.cg.teddyamazing.model.user.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {
    Role findByRoleName(String name);
}
