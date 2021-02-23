package com.cg.teddyamazing.repository.user;

import com.cg.teddyamazing.model.user.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepo extends PagingAndSortingRepository<Account, Long> {
}
