package com.chi.demo10.accounts.service.impl;

import java.lang.classfile.ClassFile.Option;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.chi.demo10.accounts.constants.AccountsConstants;
import com.chi.demo10.accounts.dto.AccountsDto;
import com.chi.demo10.accounts.dto.CustomerDto;
import com.chi.demo10.accounts.entity.Accounts;
import com.chi.demo10.accounts.entity.Customer;
import com.chi.demo10.accounts.mapper.AccountsMapper;
import com.chi.demo10.accounts.mapper.CustomerMapper;
import com.chi.demo10.accounts.repository.AccountsRepository;
import com.chi.demo10.accounts.repository.CustomerRepository;
import com.chi.demo10.accounts.service.IAccountService;
import com.chi.demo10.exceptions.CustomerAlreadyExistException;
import com.chi.demo10.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

// 繼承介面寫法，在這邊撰寫邏輯

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    
    /**
     * @param customerDto - CustomerDto object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobile(customerDto.getMobile());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobile " + customerDto.getMobile());
        }

        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    public Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

    /**
     * @param mobile - Input Mobile
     * @return Accounts Details based on a given mobile
     */
    @Override
    public CustomerDto fetchAccount(String mobile) {

        Customer customer = customerRepository.findByMobile(mobile).orElseThrow(
            () -> new ResourceNotFoundException("Customer", "mobile", mobile)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
            () -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto != null) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);
        }
        throw new UnsupportedOperationException(" Unimplemented method 'updateAccount'");
    }

    @Override
    public boolean deleteAccount(String mobile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }
    
}
