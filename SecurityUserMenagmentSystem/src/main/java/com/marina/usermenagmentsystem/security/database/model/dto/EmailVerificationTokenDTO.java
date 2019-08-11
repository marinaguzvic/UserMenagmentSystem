/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.database.model.dto;

import com.marina.usermenagmentsystem.security.database.model.Account;
import java.util.Date;

/**
 *
 * @author MARINA
 */
public class EmailVerificationTokenDTO {

    private Long id;

    private String token;

    private AccountDTO account;

    private Date expiryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date date) {
        this.expiryDate = date;
    }
}
