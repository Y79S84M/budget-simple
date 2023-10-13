package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
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
    public BankAccountInfo updateBankAccount(BankAccountInfo updateInfo) throws BankAccountNotFoundException {
        BankAccount bkAcc = getBankAccountByUUID(UUID.fromString(updateInfo.getAccId()));
        if (null!=bkAcc) {
            BankAccountMapper.map(updateInfo, bkAcc);
            bkAcc = bkAccRepo.save(bkAcc);
            updateInfo = BankAccountMapper.toBankAccountInfo(bkAcc);
            return updateInfo;
        }
        throw new BankAccountNotFoundException("Resource not found.", updateInfo);
    }

    @Override
    public BankAccount getBankAccountByUUID(UUID id) {
        Optional<BankAccount> bkAcc = bkAccRepo.getByUUID(id);
        return bkAcc.orElse(null);
    }

}
