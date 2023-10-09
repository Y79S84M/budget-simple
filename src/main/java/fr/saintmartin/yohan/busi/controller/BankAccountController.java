package fr.saintmartin.yohan.busi.controller;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.RestResponse;
import fr.saintmartin.yohan.busi.dto.SuccessRestResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank_account")
public class BankAccountController {

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<RestResponse> createBankAccount(@RequestBody @Valid BankAccountCreation bkAcc) {

        return new ResponseEntity<>(new SuccessRestResponse("Your bank account has been created",
                HttpStatus.CREATED.value(), HttpStatus.CREATED.name()), HttpStatus.CREATED);
    }
}
