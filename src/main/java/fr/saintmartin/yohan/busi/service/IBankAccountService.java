package fr.saintmartin.yohan.busi.service;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import jakarta.persistence.EntityNotFoundException;

public interface IBankAccountService {

    BankAccountInfo createBankAccount(BankAccountCreation bkAcc);
    BankAccountInfo updateBankAccount(BankAccountInfo updatedBkAcc) throws EntityNotFoundException;
}
