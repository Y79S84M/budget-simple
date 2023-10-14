package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class BankAccountUpdate {
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
    private String type;
    @NotNull(message = "account creation date must be provided")
    @NotEmpty(message = "account creation date must not be empty")
    @JsonProperty("created_on")
    private String createdOn;

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
