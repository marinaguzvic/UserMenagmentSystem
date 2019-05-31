/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.Account;
import com.marina.usermenagmentsystem.service.model.AccountDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDtoModel(Account account);

    List<AccountDTO> toDtoModel(List<Account> accounts);

    Account toDataModel(AccountDTO account);
}
