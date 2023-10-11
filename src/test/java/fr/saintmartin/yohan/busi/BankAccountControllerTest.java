package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BankAccountControllerTest {

    @Autowired
    MockMvc bkAccCtrl;

    @MockBean
    BankAccountService bkAccSrv;

    @Test
    public void createBkAccEndPoint_returns201_WhenBankAccountCreationIsValid() throws Exception {
        BankAccountInfo bkAccInfo = new BankAccountInfo();
        bkAccInfo.setAccId("123-455");
        bkAccInfo.setAlias("joint account");
        bkAccInfo.setBalance("342.76");
        bkAccInfo.setType("current");
        when(bkAccSrv.createBankAccount(any())).thenReturn(bkAccInfo);
        MvcResult restResp = bkAccCtrl.perform(MockMvcRequestBuilders.post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BankAccountFixtures.VALID_CREATION))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn();
        assertThat(restResp.getResponse().getContentAsString()).contains("data");
        assertThat(restResp.getResponse().getContentAsString()).contains("bank_account_id");
    }

    @Test
    public void createBkAccEndPoint_returns400_WhenBankAccountCreationIsNotValid() throws Exception {
        bkAccCtrl.perform(MockMvcRequestBuilders.post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BankAccountFixtures.NOT_VALID_CREATION))
                .andExpect(status().isBadRequest());
    }
}
