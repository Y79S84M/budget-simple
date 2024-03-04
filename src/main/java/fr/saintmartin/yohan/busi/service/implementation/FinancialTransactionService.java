package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.FinancialTransactionCreation;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionDTO;
import fr.saintmartin.yohan.busi.dto.FinancialTransactionUpdate;
import fr.saintmartin.yohan.busi.repository.FinancialTransactionRepository;
import fr.saintmartin.yohan.busi.service.IFinancialTransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FinancialTransactionService implements IFinancialTransactionService {
    private final FinancialTransactionRepository ftrRepo;
    public FinancialTransactionService(FinancialTransactionRepository ftrRepo){
        this.ftrRepo = ftrRepo;
    }
    @Override
    public FinancialTransactionDTO addFtr(FinancialTransactionCreation ftToCreate) {
        return null;
    }
    @Override
    public FinancialTransactionDTO getAllFtr(Long bankAccountId) {return null;}
    @Override
    public FinancialTransactionDTO updateFtr(FinancialTransactionUpdate ftToUpdate) {
        return null;
    }

}
