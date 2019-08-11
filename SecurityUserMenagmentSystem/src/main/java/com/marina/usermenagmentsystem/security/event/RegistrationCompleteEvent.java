/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.event;

import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import java.util.Locale;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
public class RegistrationCompleteEvent extends ApplicationEvent{

    private String appUrl;
    private Locale locale;
    private Account account;
    
    public RegistrationCompleteEvent(Account account, Locale locale, String appUrl) {
        super(account);
        this.account = account;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
