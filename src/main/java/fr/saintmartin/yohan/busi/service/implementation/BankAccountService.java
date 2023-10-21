package fr.saintmartin.yohan.busi.service.implementation;

import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
import fr.saintmartin.yohan.busi.mapper.BankAccountMapper;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.IBankAccountService;
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
    public BankAccountInfo createBankAccount(BankAccountDTO bkAccCreation) {
            BankAccount bkAcc = BankAccountMapper.mapFrom(bkAccCreation);
            bkAcc = bkAccRepo.save(bkAcc);
            return BankAccountMapper.mapToBankAccountInfoFrom(bkAcc);
    }

    @Override
    public BankAccountInfo updateBankAccount(BankAccountDTO bkAccUpdate) throws BankAccountNotFoundException {
        BankAccount bkAcc = getBankAccountByUUID(UUID.fromString(bkAccUpdate.getAccId()));
        if (null!=bkAcc) {
            System.err.println(bkAcc.getUuid());
            System.err.println("Before mapping value : " + bkAcc.getType());
            BankAccountMapper.map(bkAccUpdate, bkAcc);
            System.err.println("After mapping value : " + bkAcc.getType());
            bkAccRepo.save(bkAcc);
            return BankAccountMapper.mapToBankAccountInfoFrom(bkAcc);
        }
        throw new BankAccountNotFoundException("Resource not found", bkAccUpdate);
    }

    @Override
    public BankAccount getBankAccountByUUID(UUID id) {
        Optional<BankAccount> bkAcc = bkAccRepo.getByUUID(id);
        return bkAcc.orElse(null);
    }

}
