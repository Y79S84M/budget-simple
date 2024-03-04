package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.FinancialTransactionCreation;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionDTO;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionUpdate;

public interface IFinancialTransactionService {
    FinancialTransactionDTO addFtr(FinancialTransactionCreation ftToCreate);
    FinancialTransactionDTO getAllFtr(Long bankAccountId);
    FinancialTransactionDTO updateFtr(FinancialTransactionUpdate ftToUpdate);
}
