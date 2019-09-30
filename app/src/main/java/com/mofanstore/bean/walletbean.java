package com.mofanstore.bean;

import java.util.List;

public class walletbean {
    private String balance;
    private String blocked_show;
    private String allowshow;
    private List<walletlogbean> log;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBlocked_show() {
        return blocked_show;
    }

    public void setBlocked_show(String blocked_show) {
        this.blocked_show = blocked_show;
    }

    public String getAllowshow() {
        return allowshow;
    }

    public void setAllowshow(String allowshow) {
        this.allowshow = allowshow;
    }

    public List<walletlogbean> getLog() {
        return log;
    }

    public void setLog(List<walletlogbean> log) {
        this.log = log;
    }
}
