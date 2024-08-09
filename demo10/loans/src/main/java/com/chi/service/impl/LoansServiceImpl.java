package com.chi.service.impl;

import com.chi.constants.LoansConstants;
import com.chi.dto.LoansDto;
import com.chi.entity.Loans;
import com.chi.exception.LoanAlreadyExistsException;
import com.chi.repository.LoansRepository;
import com.chi.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    /**
     * @param mobile - Mobile of the Customer
     */
    @Override
    public void createLoan(String mobile) {
        Optional<Loans> optionalLoans= loansRepository.findByMobile(mobile);
        if(optionalLoans.isPresent()){
           throw new LoanAlreadyExistsException("Loan already registered with given mobile " + mobile);
        }
        Loans loan = createNewLoan(mobile);
        loan.setCreateUser("a_user");
        loan.setCreateTime(LocalDateTime.now());
        loansRepository.save(loan);
    }

    /**
     * @param mobile - Mobile of the Customer
     * @return the new loan details
     */
    public Loans createNewLoan(String mobile) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobile(mobile);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoansDto fetchLoan(String mobile) {
        return null;
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        return false;
    }

    @Override
    public boolean deleteLoan(String mobile) {
        return false;
    }

}
