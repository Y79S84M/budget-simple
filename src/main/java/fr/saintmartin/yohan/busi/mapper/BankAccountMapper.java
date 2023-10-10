package fr.saintmartin.yohan.busi.mapper;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;

import java.util.Map;

public class BankAccountMapper {
    private static final Map<String, AccountType> accountTypeMapping = Map.of(
            "current",AccountType.CURRENT,
            "saving",AccountType.SAVING,
            "deposit",AccountType.DEPOSIT
    );
    public static BankAccount from(BankAccountCreation bkAccCreation) {
        BankAccount bkAcc = new BankAccount();
        bkAcc.setAlias(bkAccCreation.getAlias());
        bkAcc.setBalance(bkAccCreation.getBalance());
        bkAcc.setType(toAccountType(bkAccCreation.getBankAccountType()));
        return bkAcc;
    }

    private static AccountType toAccountType(String bankAccountType) {
        return accountTypeMapping.get(bankAccountType);
    }

    public static BankAccountInfo toBankAccountInfo(BankAccount bkAcc) {
        BankAccountInfo bkAccInfo = new BankAccountInfo();
        bkAccInfo.setAccId(bkAcc.getAccId().toString());
        bkAccInfo.setAlias(bkAcc.getAlias());
        bkAccInfo.setBalance(String.valueOf(bkAcc.getBalance()));
        bkAccInfo.setType(bkAcc.getType().name());
        return bkAccInfo;
    }
}
