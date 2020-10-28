package com.example.demo02.service.impl;

import com.example.demo02.Mapper.AccountMapper;
import com.example.demo02.model.Account;
import com.example.demo02.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceimpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> listAllAccount() {
        List<Account> list=accountMapper.findAll();
        return list;
    }

    @Override
    public Account getAccount(String acardNo) {
        Account account=accountMapper.findOne(acardNo);
        return account;
    }

    @Override
    public int createAccount(Account account) {
        int cnt=accountMapper.insert(account);
        return cnt;
    }

    @Override
    public int deleteAccount(String acardNo) {
        int cnt=accountMapper.delete(acardNo);
        return cnt;
    }
}
