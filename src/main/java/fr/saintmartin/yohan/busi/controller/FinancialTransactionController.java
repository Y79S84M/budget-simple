package fr.saintmartin.yohan.busi.controller;

import fr.saintmartin.yohan.busi.dto.FinancialTransactionCreation;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionDTO;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionUpdate;
import fr.saintmartin.yohan.busi.dto.response.RestResponse;
import fr.saintmartin.yohan.busi.dto.response.SuccessRestResponse;
import fr.saintmartin.yohan.busi.service.IFinancialTransactionService;
import fr.saintmartin.yohan.busi.service.implementation.FinancialTransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/transaction", consumes= MediaType.APPLICATION_JSON_VALUE)
public class FinancialTransactionController {

    private final IFinancialTransactionService ftrSrv;

    public FinancialTransactionController(FinancialTransactionService ftrSrv) {
        this.ftrSrv = ftrSrv;
    }

    @PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> addFt(@RequestBody @Valid FinancialTransactionCreation ftToCreate) {
        FinancialTransactionDTO ftrDto = ftrSrv.addFtr(ftToCreate);
        return new ResponseEntity<>(
                new SuccessRestResponse("Financial transaction has been added successfully.",
                        ftrDto,
                        HttpStatus.CREATED.value(),
                        "Created"),
                HttpStatus.CREATED);
    }

    @PostMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> updateFt(@RequestBody @Valid FinancialTransactionUpdate ftrToUpdate) {
        FinancialTransactionDTO ftrDto = ftrSrv.updateFtr(ftrToUpdate);
        return new ResponseEntity<>(
                new SuccessRestResponse("Financial transaction has been updated successfully.",
                        ftrDto,
                        HttpStatus.ACCEPTED.value(),
                        "Accepted"),
                HttpStatus.ACCEPTED);
    }
}
