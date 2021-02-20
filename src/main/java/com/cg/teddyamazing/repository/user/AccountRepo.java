package com.cg.teddyamazing.repository.user;

import com.cg.teddyamazing.model.user.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account,Long> {
    Account findByUserName(String userName);
}
