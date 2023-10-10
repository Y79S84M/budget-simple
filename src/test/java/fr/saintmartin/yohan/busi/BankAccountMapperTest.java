package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.dto.BankAccountCreation;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.mapper.BankAccountMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountMapperTest {

    @Test
    public void toAccountType_returnsCURRENT_whenCreateBankAccountRequestBodyContainsTypeCurrent() {
        BankAccountCreation bkAccCreation = new BankAccountCreation();
        bkAccCreation.setBankAccountType("current");
        bkAccCreation.setBalance(100.00);
        bkAccCreation.setAlias("compte courant");
        BankAccount bkAcc = BankAccountMapper.from(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.CURRENT);
    }

    @Test
    public void toAccountType_returnsSAVING_whenCreateBankAccountRequestBodyContainsTypeSaving() {
        BankAccountCreation bkAccCreation = new BankAccountCreation();
        bkAccCreation.setBankAccountType("saving");
        bkAccCreation.setBalance(100.00);
        bkAccCreation.setAlias("compte épargne");
        BankAccount bkAcc = BankAccountMapper.from(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.SAVING);
    }

    @Test
    public void toAccountType_returnsDEPOSIT_whenCreateBankAccountRequestBodyContainsTypeDeposit() {
        BankAccountCreation bkAccCreation = new BankAccountCreation();
        bkAccCreation.setBankAccountType("deposit");
        bkAccCreation.setBalance(100.00);
        bkAccCreation.setAlias("compte épargne");
        BankAccount bkAcc = BankAccountMapper.from(bkAccCreation);
        assertThat(bkAcc.getType()).isEqualTo(AccountType.DEPOSIT);
    }
}
