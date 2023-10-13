package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;

import java.util.UUID;

public interface IBankAccountService {

    BankAccountInfo createBankAccount(BankAccountCreation bkAcc);
    BankAccountInfo updateBankAccount(BankAccountInfo updateInfo) throws BankAccountNotFoundException;
    BankAccount getBankAccountByUUID(UUID id);
}
