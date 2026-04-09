package me.dgrachov.studyplanner.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import me.dgrachov.studyplanner.dto.AccountMessageDTO;
import me.dgrachov.studyplanner.model.AccountMessage;

public class AccountMessageMapper implements Mapper<AccountMessage, AccountMessageDTO> {
    @Override
    public AccountMessage toBase(AccountMessageDTO dto) {
        var accountMessage = new AccountMessage();

        accountMessage.setId(dto.getId());
        accountMessage.setSender(dto.getSender());
        accountMessage.setContent(dto.getContent());
        accountMessage.setRead(dto.getIsRead());
        accountMessage.setTimestamp(Instant.ofEpochSecond(dto.getEpochSeconds()));

        return accountMessage;
    }

    @Override
    public List<AccountMessage> toBaseList(List<AccountMessageDTO> dtoList) {
        var messages = new ArrayList<AccountMessage>();

        for (var accountMessageDTO : dtoList) {
            messages.add(toBase(accountMessageDTO));
        }

        return messages;
    }

    @Override
    public AccountMessageDTO toDTO(AccountMessage accountMessage) {
        var dto = new AccountMessageDTO();

        dto.setId(accountMessage.getId());
        dto.setSender(accountMessage.getSender());
        dto.setContent(accountMessage.getContent());
        dto.setIsRead(accountMessage.isRead());
        dto.setEpochSeconds(accountMessage.getTimestamp().getEpochSecond());

        return dto;
    }

    @Override
    public List<AccountMessageDTO> toDTOList(List<AccountMessage> baseList) {
        var messageDTOs = new ArrayList<AccountMessageDTO>();

        for (var accountMessage : baseList) {
            messageDTOs.add(toDTO(accountMessage));
        }

        return messageDTOs;
    }
}
