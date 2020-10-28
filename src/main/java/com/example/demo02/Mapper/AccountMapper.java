package com.example.demo02.Mapper;

import com.example.demo02.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    /*查询指定卡号数据*/
    public Account findOne(String acardNo);

    /*查询所有数据*/
    public List<Account> findAll();

    /*插入数据*/
    public int insert(Account data);

    /*删除指定卡号数据*/
    public int delete(String acardNo);
}


