package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.dto.BankAccountUpdate;
import fr.saintmartin.yohan.busi.entity.BankAccount;

public interface IBankAccountService {

    BankAccountInfo createBankAccount(BankAccountCreation bkAcc);
    BankAccount updateBankAccount(BankAccountUpdate updatedBkAcc, BankAccount bkAcc);
}
