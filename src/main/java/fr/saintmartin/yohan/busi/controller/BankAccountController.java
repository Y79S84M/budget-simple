package fr.saintmartin.yohan.busi.controller;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.dto.RestResponse;
import fr.saintmartin.yohan.busi.dto.SuccessRestResponse;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank_account")
public class BankAccountController {

    private final IBankAccountService bkAccSrv;

    public BankAccountController(BankAccountService bkAccSrv) {
        this.bkAccSrv = bkAccSrv;
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<RestResponse> createBankAccount(@RequestBody @Valid BankAccountCreation bkAcc) {
        BankAccountInfo bkAccInfo = bkAccSrv.createBankAccount(bkAcc);
        return new ResponseEntity<>(new SuccessRestResponse("Your bank account has been created", bkAccInfo,
                HttpStatus.CREATED.value(), HttpStatus.CREATED.name()), HttpStatus.CREATED);
    }
}
