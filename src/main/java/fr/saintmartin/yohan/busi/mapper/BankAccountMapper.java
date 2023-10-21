package fr.saintmartin.yohan.busi.mapper;

import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.CustomDateTimeFormatter;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;

public class BankAccountMapper {
    private static final Map<String, AccountType> accountTypeMapping = Map.of(
            "CURRENT",AccountType.CURRENT,
            "SAVING",AccountType.SAVING,
            "DEPOSIT",AccountType.DEPOSIT
    );
    private static AccountType toAccountType(String bankAccountType) {
        return accountTypeMapping.get(bankAccountType);
    }

    public static BankAccount mapFrom(BankAccountDTO bkAccData) {
        BankAccount bkAcc = new BankAccount();
        bkAcc.setUuid(UUID.randomUUID());
        bkAcc.setAlias(bkAccData.getAlias());
        bkAcc.setBalance(parseDouble(bkAccData.getBalance()));
        bkAcc.setType(toAccountType(bkAccData.getType().toUpperCase()));
        bkAcc.setCreatedOn(LocalDate.now());
        bkAcc.setUpdatedOn(LocalDate.now());
        return bkAcc;
    }

    public static BankAccountInfo mapToBankAccountInfoFrom(BankAccount bkAcc) {
            BankAccountInfo bkAccInfo = new BankAccountInfo();
            bkAccInfo.setAccId(valueOf(bkAcc.getUuid()));
            bkAccInfo.setAlias(bkAcc.getAlias());
            bkAccInfo.setBalance(valueOf(bkAcc.getBalance()));
            bkAccInfo.setType(bkAcc.getType().name().toLowerCase());
            bkAccInfo.setCreatedOn(CustomDateTimeFormatter.localDateToString(bkAcc.getCreatedOn()));
            return bkAccInfo;
    }

    public static void map(BankAccountDTO updatedInfo, BankAccount bkAcc) {
        bkAcc.setUuid(UUID.fromString(updatedInfo.getAccId()));
        bkAcc.setAlias(updatedInfo.getAlias());
        bkAcc.setType(toAccountType(updatedInfo.getType().toUpperCase()));
        bkAcc.setCreatedOn(CustomDateTimeFormatter.toLocalDate(updatedInfo.getCreatedOn()));
        bkAcc.setUpdatedOn(LocalDate.now());
    }
}
