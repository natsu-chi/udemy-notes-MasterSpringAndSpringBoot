package com.chi.demo10.accounts.controller;

import com.chi.demo10.accounts.dto.AccountsDto;
import com.chi.demo10.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chi.demo10.accounts.constants.AccountsConstants;
import com.chi.demo10.accounts.dto.CustomerDto;
import com.chi.demo10.accounts.dto.ResponseDto;

@RestController
@RequestMapping(path = "/api", produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class AccountsController {

    private IAccountsService iAccountsService;
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomerById(@RequestParam
                                                         @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobile) {
        CustomerDto customerDto = iAccountsService.fetchAccount(mobile);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteAccount(@RequestParam 
                                                @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobile) {
        
        boolean isDeleted = iAccountsService.deleteAccount(mobile);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
                                               
    }
}
