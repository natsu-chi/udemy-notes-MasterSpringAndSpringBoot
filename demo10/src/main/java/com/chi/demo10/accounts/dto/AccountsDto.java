package com.chi.demo10.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    
    private Long customerId;
    
    @NotEmpty(message = "AccountNumber is required")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "AccountType is required")
    private String accountType;

    private String branchAddress;
}
