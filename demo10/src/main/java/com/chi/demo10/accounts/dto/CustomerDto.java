package com.chi.demo10.accounts.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerDto {
    
    private Long customerId;

    private String name;

    private LocalDate email;

    private String mobile;

    private AccountsDto accountsDto;

}
