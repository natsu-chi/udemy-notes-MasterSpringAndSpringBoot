package com.chi.demo10.accounts.mapper;

import com.chi.demo10.accounts.dto.AccountsDto;
import com.chi.demo10.accounts.entity.Accounts;

public class AccountsMapper {
    
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setCustomerId(accounts.getCustomerId());
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setCustomerId(accountsDto.getCustomerId());
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

}
