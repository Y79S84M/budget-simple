package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.FinancialTransactionCreation;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionDTO;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionUpdate;
import fr.saintmartin.yohan.busi.service.IFinancialTransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FinancialTransactionService implements IFinancialTransactionService {
    @Override
    public FinancialTransactionDTO addFtr(FinancialTransactionCreation ftToCreate) {
        return null;
    }

    @Override
    public FinancialTransactionDTO updateFtr(FinancialTransactionUpdate ftToUpdate) {
        return null;
    }

}
