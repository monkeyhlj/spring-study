package com.monkey.springbootshrio.service;

import com.monkey.springbootshrio.entity.Account;

public interface AccountService {
    public Account findByUsername(String username);
}
