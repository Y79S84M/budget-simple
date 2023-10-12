package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.mapper.BankAccountMapper;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class BankAccountService implements IBankAccountService {

    private final BankAccountRepository bkAccRepo;

    public BankAccountService(BankAccountRepository bkAccRepo) {
        this.bkAccRepo = bkAccRepo;
    }
    @Override
    public BankAccountInfo createBankAccount(BankAccountCreation bkAccCreation) {
            BankAccount bkAcc = BankAccountMapper.from(bkAccCreation);
            bkAcc = bkAccRepo.save(bkAcc);
            return BankAccountMapper.toBankAccountInfo(bkAcc);
    }

    @Override
    public BankAccountInfo updateBankAccount(BankAccountInfo updatedBkAcc) {
        Optional<BankAccount> optBkAcc = bkAccRepo.getByUUID(UUID.fromString(updatedBkAcc.getAccId()));
        if(optBkAcc.isPresent()) {
            BankAccount bkAcc = BankAccountMapper.map(updatedBkAcc,optBkAcc.get());
            bkAcc = bkAccRepo.save(bkAcc);
            updatedBkAcc = BankAccountMapper.toBankAccountInfo(bkAcc);
            return updatedBkAcc;
        } else {
            throw new EntityNotFoundException("Resource could not be retrieved");
        }
    }

}
