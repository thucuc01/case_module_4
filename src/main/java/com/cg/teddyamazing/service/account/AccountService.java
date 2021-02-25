package com.cg.teddyamazing.service.account;
import com.cg.teddyamazing.model.account.Account;
import com.cg.teddyamazing.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IGenerateService<Account, Long>, UserDetailsService {
}
