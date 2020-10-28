package com.example.demo02.controller;


import com.example.demo02.model.Account;
import com.example.demo02.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;
    //获取所有信息
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAllAccount(){
        Map<String,Object> result=new HashMap<String,Object>();
        try{
            List<Account> list=this.accountService.listAllAccount();
            result.put("status","ok");
            result.put("list",list);
        }catch (Exception ex){
            result.put("status","failure");
            result.put("errMsg",ex.getMessage());
            logger.error(ex.getMessage(),ex);
        }finally {
        }
        return result;
    }

    //指定用户信息取得
    @RequestMapping(value = "detail/{acardNo}",method = RequestMethod.GET)
    public Object getAccountDetail(@PathVariable String acardNo){
        Map<String,Object> result=new HashMap<String,Object>();
        try{
            Account account=this.accountService.getAccount(acardNo);
            if(account!=null){
                result.put("status","ok");
                result.put("account",account);
            }else{
                result.put("status","failure");
                result.put("errMsg","账户不存在");
            }
        }catch (Exception ex){
            result.put("status","failure");
            result.put("errMsg",ex.getMessage());
            logger.error(ex.getMessage(),ex);
        }finally {
        }
        return result;
    }

    //创建账户信息
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createAccount(
            @RequestParam(value = "acardNo",required =true) String acardNo,
            @RequestParam(value = "money",required = true) Double money,
            @RequestParam(value = "pwd",required = false) String pwd,
            @RequestParam(value = "aname",required = false) String aname){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            Account account=new Account();
            account.setAcardNo(acardNo);
            account.setAname(aname);
            account.setMoney(money);
            account.setPwd(pwd);
            int cnt=this.accountService.createAccount(account);
            if(cnt>0){
                result.put("status","ok");
                result.put("account",account);
            }else{
                result.put("status", "failure");
                result.put("errMsg", "账户创建失败");
            }
        }catch (Exception ex){
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        }finally {
        }
        return result;
    }

    //指定账户信息删除
    @RequestMapping(value = "/delete/{acardNo}", method = RequestMethod.GET)
    public Object deleteAccount(@PathVariable String acardNo){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            int cnt = accountService.deleteAccount(acardNo);
            if(cnt>0){
                result.put("status", "ok");
            }else{
                result.put("status", "failure");
                result.put("errMsg", "账户删除失败");
            }
        }catch (Exception ex){
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        }finally {
        }
        return  result;
    }
}
