package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.dto.BankAccountUpdate;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;

import java.util.UUID;

public interface IBankAccountService {

    BankAccountInfo createBankAccount(BankAccountCreation bkAcc);
    BankAccountInfo updateBankAccount(BankAccountUpdate updateInfo) throws BankAccountNotFoundException;
    BankAccount getBankAccountByUUID(UUID id);
}
