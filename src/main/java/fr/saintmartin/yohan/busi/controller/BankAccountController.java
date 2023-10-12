package fr.saintmartin.yohan.busi.controller;

import fr.saintmartin.yohan.busi.dto.*;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import jakarta.persistence.EntityNotFoundException;
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
                HttpStatus.CREATED.value(), HttpStatus.CREATED.name()), HttpStatus.CREATED);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> updateBankAccount(@RequestBody @Valid BankAccountInfo bkAcc) {
        try {
            BankAccountInfo bkAccInfo = bkAccSrv.updateBankAccount(bkAcc);
            return new ResponseEntity<>(new SuccessRestResponse("Your bank account has been created",bkAccInfo,
                    HttpStatus.CREATED.value(), HttpStatus.CREATED.name()), HttpStatus.CREATED);
        } catch(EntityNotFoundException ex) {
            String technicalMessage = """
                    "exception_type": %s,
                    "exception_message": %s,
                    "description": No resource can be returned with the data you submitted to the application.
                    """.formatted(ex.getClass().getSimpleName(),ex.getMessage());
            return new ResponseEntity<>(new ErrorRestResponse(ex.getMessage(),technicalMessage,bkAcc,
                    HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()),HttpStatus.NOT_FOUND);
        }
    }

}
