package fr.saintmartin.yohan.busi;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountServiceTests {

    private BankAccountService accSrv;
    private BankAccountRepository bkAccRepo;

    @Test
    void updateBankAccount_ThrowsNotFoundException_WhenGetByUUIDReturnsNull() throws Exception {
        bkAccRepo = mock(BankAccountRepository.class);
        accSrv = new BankAccountService(bkAccRepo);
        BankAccountInfo bkInfo = new ObjectMapper().readValue(BankAccountFixtures.VALID_UPDATE, BankAccountInfo.class);
        when(accSrv.getBankAccountByUUID(UUID.randomUUID())).thenReturn(null);
        BankAccountNotFoundException bkEx = assertThrows(BankAccountNotFoundException.class, () -> accSrv.updateBankAccount(bkInfo));

        assertThat(bkEx).message().isEqualTo("Resource not found");
        assertThat(bkEx).isInstanceOf(BankAccountNotFoundException.class);
    }
}
