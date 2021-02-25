package com.cg.teddyamazing.repository.account;
import com.cg.teddyamazing.model.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AccountRepo extends PagingAndSortingRepository<Account, Long> {
    Account findByUserName(String userName);
}
