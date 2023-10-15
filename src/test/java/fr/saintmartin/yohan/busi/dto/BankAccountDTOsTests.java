package fr.saintmartin.yohan.busi.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountDTOsTests {
    private static Validator validator;
    @BeforeAll
    static void setupValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    @Test
    void violationShouldBeReported_WhenBankAccountCreationTypeIsNotValid() {
        BankAccountDTO bkAccCr = new BankAccountCreation();
        bkAccCr.setAlias("compte courant");
        bkAccCr.setType("invalid");
        bkAccCr.setBalance("100.00");

        Set<ConstraintViolation<BankAccountDTO>> violations = validator.validate(bkAccCr);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(p->"type".equals(p.getPropertyPath().toString()));
        assertThat(violations).anyMatch(p->"Type must be one of the following values: [CURRENT, SAVING, DEPOSIT]".equals(p.getMessage()));
    }
    @Test
    void violationShouldBeReported_WhenBankAccountUpdateTypeIsNotValid() {
        BankAccountDTO bkAccUpdate = new BankAccountUpdate();
        bkAccUpdate.setAccId(String.valueOf(UUID.randomUUID()));
        bkAccUpdate.setAlias("compte courant");
        bkAccUpdate.setType("invalid");
        bkAccUpdate.setCreatedOn("10.10.2023");

        Set<ConstraintViolation<BankAccountDTO>> violations = validator.validate(bkAccUpdate);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(p->"type".equals(p.getPropertyPath().toString()));
        assertThat(violations).anyMatch(p->"Type must be one of the following values: [CURRENT, SAVING, DEPOSIT]".equals(p.getMessage()));
    }
}
