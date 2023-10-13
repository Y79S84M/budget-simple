package fr.saintmartin.yohan.busi.controller;

import fr.saintmartin.yohan.busi.dto.*;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bank_account", consumes = MediaType.APPLICATION_JSON_VALUE)
public class BankAccountController {

    private final Logger log = LoggerFactory.getLogger(BankAccountController.class);
    private final IBankAccountService bkAccSrv;

    public BankAccountController(BankAccountService bkAccSrv) {
        this.bkAccSrv = bkAccSrv;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> createBankAccount(@RequestBody @Valid BankAccountCreation bkAcc) {
        BankAccountInfo bkAccInfo = bkAccSrv.createBankAccount(bkAcc);
        return new ResponseEntity<>(new SuccessRestResponse("Your bank account has been created",bkAccInfo,
                HttpStatus.CREATED.value(), "Created"), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> updateBankAccount(@RequestBody @Valid BankAccountInfo bkAccInfo) {
        bkAccInfo = bkAccSrv.updateBankAccount(bkAccInfo);
        return new ResponseEntity<>(new SuccessRestResponse("Your bank account has been updated",bkAccInfo,
                HttpStatus.ACCEPTED.value(), "Accepted"), HttpStatus.ACCEPTED);
    }

}
