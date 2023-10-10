package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.dto.BankAccountUpdate;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.mapper.BankAccountMapper;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
import org.springframework.stereotype.Service;

@Service
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
    public BankAccount updateBankAccount(BankAccountUpdate updatedBkAcc, BankAccount bkAcc) {
        bkAcc.setAlias(updatedBkAcc.getAlias());
        bkAcc.setType(updatedBkAcc.getType());
        return bkAccRepo.save(bkAcc);
    }
}
