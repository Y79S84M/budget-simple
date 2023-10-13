package fr.saintmartin.yohan.busi.mapper;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.CustomDateTimeFormatter;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static java.lang.String.valueOf;

public class BankAccountMapper {
    private static final Map<String, AccountType> accountTypeMapping = Map.of(
            "current",AccountType.CURRENT,
            "saving",AccountType.SAVING,
            "deposit",AccountType.DEPOSIT
    );
    public static BankAccount from(BankAccountCreation bkAccCreation) {
        BankAccount bkAcc = new BankAccount();
        bkAcc.setUuid(UUID.randomUUID());
        bkAcc.setAlias(bkAccCreation.getAlias());
        bkAcc.setBalance(bkAccCreation.getBalance());
        bkAcc.setType(toAccountType(bkAccCreation.getBankAccountType()));
        bkAcc.setCreatedOn(LocalDate.now());
        bkAcc.setUpdatedOn(LocalDate.now());
        return bkAcc;
    }

    public static void map(BankAccountInfo from, BankAccount to) {
        to.setUuid(UUID.fromString(from.getAccId()));
        to.setAlias(from.getAlias());
        to.setBalance(Double.parseDouble(from.getBalance()));
        to.setType(toAccountType(from.getType().toLowerCase()));
        to.setUpdatedOn(LocalDate.now());
    }

    public static BankAccountInfo toBankAccountInfo(BankAccount bkAcc) {
            BankAccountInfo bkAccInfo = new BankAccountInfo();
            bkAccInfo.setAccId(valueOf(bkAcc.getUuid()));
            bkAccInfo.setAlias(bkAcc.getAlias());
            bkAccInfo.setBalance(valueOf(bkAcc.getBalance()));
            bkAccInfo.setType(bkAcc.getType().name().toLowerCase());
            bkAccInfo.setCreatedOn(CustomDateTimeFormatter.localDateToString(bkAcc.getCreatedOn()));
            return bkAccInfo;
    }

    private static AccountType toAccountType(String bankAccountType) {
        return accountTypeMapping.get(bankAccountType);
    }
}
