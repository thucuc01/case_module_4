package com.cg.teddyamazing.repository.role;

import com.cg.teddyamazing.model.account.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepo extends CrudRepository<Role, Long> {
}
