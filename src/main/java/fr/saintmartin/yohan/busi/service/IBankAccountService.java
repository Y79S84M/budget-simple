package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;

import java.util.UUID;

public interface IBankAccountService {

    BankAccountInfo createBankAccount(BankAccountDTO bkAcc);
    BankAccountInfo updateBankAccount(BankAccountDTO updateInfo) throws BankAccountNotFoundException;
    BankAccount getBankAccountByUUID(UUID id);
}
