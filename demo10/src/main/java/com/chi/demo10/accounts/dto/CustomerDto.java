package com.chi.demo10.accounts.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDto {
    
    private Long customerId;

    private String name;

    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobile;

    private AccountsDto accountsDto;

}
