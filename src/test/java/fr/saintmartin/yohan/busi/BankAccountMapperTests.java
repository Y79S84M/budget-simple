package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.mapper.BankAccountMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountMapperTests {

    @Test
    public void toAccountType_returnsCURRENT_whenCreateBankAccountRequestBodyContainsTypeCurrent() {
        BankAccountDTO bkAccCreation = new BankAccountCreation();
        bkAccCreation.setAlias("compte courant");
        bkAccCreation.setType("Current");
        bkAccCreation.setBalance("100.00");
        BankAccount bkAcc = BankAccountMapper.mapFrom(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.CURRENT);
    }

    @Test
    public void toAccountType_returnsSAVING_whenCreateBankAccountRequestBodyContainsTypeSaving() {
        BankAccountCreation bkAccCreation = new BankAccountCreation();
        bkAccCreation.setAlias("compte epargne");
        bkAccCreation.setType("Saving");
        bkAccCreation.setBalance("100.00");
        BankAccount bkAcc = BankAccountMapper.mapFrom(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.SAVING);
    }

    @Test
    public void toAccountType_returnsDEPOSIT_whenCreateBankAccountRequestBodyContainsTypeDeposit() {
        BankAccountCreation bkAccCreation = new BankAccountCreation();
        bkAccCreation.setAlias("compte de depot");
        bkAccCreation.setType("Deposit");
        bkAccCreation.setBalance("100.00");
        BankAccount bkAcc = BankAccountMapper.mapFrom(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.DEPOSIT);
    }

    @Test
    public void toAccountInfo_returnsAliasBalanceTypeUUIDAndCreatedOn() {
        BankAccount bkAcc = new BankAccount();
        bkAcc.setUuid(UUID.randomUUID());
        bkAcc.setType(AccountType.SAVING);
        bkAcc.setBalance(235.67);
        bkAcc.setCreatedOn(LocalDate.of(2023,10,11));
        bkAcc.setUpdatedOn(LocalDate.of(2023,10,11));
        bkAcc.setAlias("saving account");
        BankAccountInfo bkAccInfo = BankAccountMapper.mapToBankAccountInfoFrom(bkAcc);

        assertThat(bkAccInfo.getCreatedOn()).isEqualTo("11.10.2023");
        assertThat(bkAccInfo.getBalance()).isEqualTo("235.67");
        assertThat(bkAccInfo.getType()).isEqualTo("saving");
    }
}
