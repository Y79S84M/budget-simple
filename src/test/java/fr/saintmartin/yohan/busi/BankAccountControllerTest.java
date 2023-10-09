package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BankAccountControllerTest {
    @Autowired
    MockMvc bkAccCtrl;

    @Test
    public void createBkAccEndPoint_returns201_WhenBankAccountCreationIsValid() throws Exception {
        bkAccCtrl.perform(MockMvcRequestBuilders.post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BankAccountFixtures.VALID_CREATION))
                .andExpect(status().isCreated());
    }

    @Test
    public void createBkAccEndPoint_returns400_WhenBankAccountCreationIsNotValid() throws Exception {
        bkAccCtrl.perform(MockMvcRequestBuilders.post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BankAccountFixtures.NOT_VALID_CREATION))
                .andExpect(status().isBadRequest());
    }
}
