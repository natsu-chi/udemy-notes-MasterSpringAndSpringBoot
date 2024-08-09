package com.chi.repository;

import com.chi.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findByMobile(String mobile);

    Optional<Loans> findByLoanNumber(String loanNumber);

}
