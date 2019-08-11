/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.mapper;

import com.marina.usermenagmentsystem.security.database.model.EmailVerificationToken;
import com.marina.usermenagmentsystem.security.database.model.dto.EmailVerificationTokenDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface EmailVerificationTokenMapper {
    EmailVerificationTokenDTO toDtoModel(EmailVerificationToken token);

    List<EmailVerificationTokenDTO> toDtoModel(List<EmailVerificationToken> tokens);

    EmailVerificationToken toDataModel(EmailVerificationTokenDTO userDto);
}
