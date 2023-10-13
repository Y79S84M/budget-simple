package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
        MvcResult restResp = bkAccCtrl.perform(post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BankAccountFixtures.VALID_CREATION))
                .andExpect(status().isCreated())
                .andReturn();
        assertThat(restResp.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        assertThat(restResp.getResponse().getContentAsString()).contains("Created");
    }

    @Test
    public void createBkAccEndPoint_returns400_WhenBankAccountCreationIsNotValid() throws Exception {
        MvcResult restResp = bkAccCtrl.perform(post("/bank_account/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(BankAccountFixtures.NOT_VALID_CREATION))
                .andExpect(status().isBadRequest())
                .andReturn();
        assertThat(restResp.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        assertThat(restResp.getResponse().getContentAsString()).contains("Bad request");
    }

    @Test
    public void updateBkAccEndPoint_returns202_WhenBankAccountIsUpdated() throws Exception {
        MvcResult restResp = bkAccCtrl.perform(put("/bank_account/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(BankAccountFixtures.VALID_UPDATE))
                        .andDo(print())
                        .andExpect(status().isAccepted())
                        .andReturn();
        assertThat(restResp.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        assertThat(restResp.getResponse().getContentAsString()).contains("Accepted");
    }

    @Test
    public void updateBkAccEndPoint_returns404_WhenUpdateBankAccountCanNotFindResource() throws Exception {
        when(bkAccSrv.updateBankAccount(any())).thenThrow(BankAccountNotFoundException.class);
        bkAccCtrl.perform(put("/bank_account/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(BankAccountFixtures.VALID_UPDATE)).andExpect(status().isNotFound());
    }
}
