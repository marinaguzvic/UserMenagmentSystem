/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.mapper;

import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "email", source = "username")
    AccountDTO toDtoModel(Account user);

    List<AccountDTO> toDtoModel(List<Account> users);

    @Mapping(target = "username", source = "email")
    Account toDataModel(AccountDTO userDto);
}
