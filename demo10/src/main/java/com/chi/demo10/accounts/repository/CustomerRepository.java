package com.chi.demo10.accounts.repository;

import com.chi.demo10.accounts.entity.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findByMobile(String mobile);
    
}
