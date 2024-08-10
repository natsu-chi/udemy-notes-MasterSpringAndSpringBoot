package com.chi.controller;

import com.chi.constants.LoansConstants;
import com.chi.dto.LoansDto;
import com.chi.dto.ResponseDto;
import com.chi.service.impl.LoansServiceImpl;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {

    private LoansServiceImpl iLoansService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                  @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile must be 10 digits")
                                                  String mobile) {
        iLoansService.createLoan(mobile);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoans(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile must be 10 digits")
                                                                      String mobile) {
        LoansDto loansDto = iLoansService.fetchLoan(mobile);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }
}
