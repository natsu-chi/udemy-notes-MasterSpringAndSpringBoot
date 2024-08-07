package com.chi.demo10.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chi.demo10.accounts.constants.AccountsConstants;
import com.chi.demo10.accounts.dto.CustomerDto;
import com.chi.demo10.accounts.dto.ResponseDto;

@RestController
@RequestMapping(path = "/api", produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
public class AccountsController {
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
}
