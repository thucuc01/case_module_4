package com.cg.teddyamazing.service.user;

import com.cg.teddyamazing.model.user.Account;

public interface AccountService {
    Account findById(Long id);
}