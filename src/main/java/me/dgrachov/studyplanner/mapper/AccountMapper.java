package me.dgrachov.studyplanner.mapper;

import java.util.ArrayList;
import java.util.List;

import me.dgrachov.studyplanner.dto.AccountDTO;
import me.dgrachov.studyplanner.model.Account;

public class AccountMapper implements Mapper<Account, AccountDTO> {
    @Override
    public Account toBase(AccountDTO dto) {
        var account = new Account();

        account.setId(dto.getId());
        account.setEmail(dto.getEmail());
        account.setUsername(dto.getUsername());

        return account;
    }

    @Override
    public List<Account> toBaseList(List<AccountDTO> dtoList) {
        var accounts = new ArrayList<Account>();

        for (var accountDTO : dtoList) {
            accounts.add(toBase(accountDTO));
        }

        return accounts;
    }

    @Override
    public AccountDTO toDTO(Account account) {
        var dto = new AccountDTO();

        dto.setId(account.getId());
        dto.setEmail(account.getEmail());
        dto.setUsername(account.getUsername());

        return dto;
    }

    @Override
    public List<AccountDTO> toDTOList(List<Account> baseList) {
        var accountDTOs = new ArrayList<AccountDTO>();

        for (var account : baseList) {
            accountDTOs.add(toDTO(account));
        }

        return accountDTOs;
    }
}
