package com.chi.demo10.accounts.dto;

import lombok.Data;

@Data
public class AccountsDto {
    
    private Long customerId;
    
    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
