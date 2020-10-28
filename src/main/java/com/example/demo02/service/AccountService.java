package com.example.demo02.service;

import com.example.demo02.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> listAllAccount();
    Account getAccount(String acardNo);
    int createAccount(Account account);
    int deleteAccount(String acardNo);
}
