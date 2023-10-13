package fr.saintmartin.yohan.busi;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import fr.saintmartin.yohan.busi.exception.BankAccountNotFoundException;
import fr.saintmartin.yohan.busi.fixtures.BankAccountFixtures;
import fr.saintmartin.yohan.busi.repository.BankAccountRepository;
import fr.saintmartin.yohan.busi.service.implementation.BankAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        ObjectMapper objMpr = new ObjectMapper();
        BankAccountInfo bkAccInfo = objMpr.readValue(BankAccountFixtures.VALID_UPDATE,BankAccountInfo.class);
        //doThrow(new BankAccountNotFoundException("Resource not found",bkAccInfo)).when(bkAccSrv).updateBankAccount(bkAccInfo);
        doReturn(null).when(bkAccSrv).getBankAccountByUUID(UUID.fromString(bkAccInfo.getAccId()));
        MvcResult restResp = bkAccCtrl.perform(put("/bank_account/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(BankAccountFixtures.VALID_UPDATE))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
        BankAccountNotFoundException bkEx = assertThrows(BankAccountNotFoundException.class,
                () -> bkAccSrv.updateBankAccount(bkAccInfo),"Resource not found");

        assertThat(bkEx).message().isEqualTo("Resource not found");
        assertThat(restResp.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        assertThat(restResp.getResponse().getContentAsString()).contains("Not found");
    }
}
