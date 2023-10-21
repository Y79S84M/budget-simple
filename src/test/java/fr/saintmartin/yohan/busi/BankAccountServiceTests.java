package fr.saintmartin.yohan.busi;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.dto.BankAccountUpdate;
import fr.saintmartin.yohan.busi.entity.BankAccount;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTests {
    @InjectMocks
    BankAccountService accSrv;
    @Mock
    BankAccountRepository bkAccRepo;

    @Test
    void updateBankAccount_ThrowsNotFoundException_WhenGetByUUIDReturnsNull() throws Exception {
        BankAccountDTO bkUpdatedInfo = new ObjectMapper().readValue(BankAccountFixtures.VALID_UPDATE, BankAccountUpdate.class);
        assertThrows(BankAccountNotFoundException.class, () -> accSrv.updateBankAccount(bkUpdatedInfo));
    }

    @Test
    void updateBankAccount_ReturnsUpdatedBankAccountData() throws Exception {
        BankAccountDTO bkUpdatedInfo = new ObjectMapper().readValue(BankAccountFixtures.VALID_UPDATE, BankAccountUpdate.class);
        BankAccount bkAcc = new BankAccount();
        bkAcc.setAccId(1L);
        bkAcc.setUuid(UUID.fromString(bkUpdatedInfo.getAccId()));
        bkAcc.setType(AccountType.CURRENT);
        bkAcc.setAlias("compte courant");
        bkAcc.setBalance(750.00);
        bkAcc.setCreatedOn(LocalDate.of(2023,10,10));
        bkAcc.setUpdatedOn(LocalDate.now());

        doReturn(Optional.of(bkAcc)).when(bkAccRepo).getByUUID(UUID.fromString(bkUpdatedInfo.getAccId()));

        BankAccountInfo bkInfo = accSrv.updateBankAccount(bkUpdatedInfo);

        assertThat(bkInfo.getType()).isEqualTo("saving");
        assertThat(bkInfo.getAlias()).isEqualTo("saving account");
    }

}
