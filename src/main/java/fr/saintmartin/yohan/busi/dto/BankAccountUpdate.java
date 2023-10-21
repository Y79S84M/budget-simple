package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.annotation.ValueOfEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class BankAccountUpdate extends BankAccountDTO {
    @NotNull(message = "Resource Id must be provided")
    @NotEmpty(message = "Resource Id must not be empty")
    @JsonProperty("bank_account_id")
    private String accId;
    @NotNull(message="Resource alias must be provided")
    @NotEmpty(message="Alias must not be empty")
    @Length(min = 3, message = "Alias must be at least 3 characters long")
    @Length(max = 32, message = "Alias length cannot be greater than 32 characters")
    private String alias;
    @NotNull(message = "Type must be provided")
    @NotEmpty(message = "Type must not be empty")
    @ValueOfEnum(listedValues = {AccountType.CURRENT, AccountType.SAVING, AccountType.DEPOSIT})
    private String type;
    @NotNull(message = "account creation date must be provided")
    @NotEmpty(message = "account creation date must not be empty")
    @JsonProperty("created_on")
    private String createdOn;

    @Override
    public String getAccId() {
        return accId;
    }

    @Override
    public void setAccId(String accId) {
        this.accId = accId;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String getCreatedOn() {
        return createdOn;
    }

    @Override
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
