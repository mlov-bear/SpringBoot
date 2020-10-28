package com.example.demo02.model;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionID=1L;
    private Double money;
    private String aname;
    private String acardNo;
    private String pwd;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAcardNo() {
        return acardNo;
    }

    public void setAcardNo(String acardNo) {
        this.acardNo = acardNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
