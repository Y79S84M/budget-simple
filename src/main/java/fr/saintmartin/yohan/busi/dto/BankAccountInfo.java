package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class BankAccountInfo {
    @NotNull(message="Resource Id must be provided")
    @NotEmpty(message="Resource Id must be provided and must not be empty")
    @JsonProperty("bank_account_id")
    private String accId;
    @NotNull(message="Resource alias must be provided")
    @NotEmpty(message="Alias must not be empty")
    @Length(min = 3, message = "Alias must be at least 3 characters long")
    @Length(max = 32, message = "Alias length cannot be greater than 32 characters")
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private String balance;
    @NotNull(message="Bank account type must be provided")
    @JsonProperty("type")
    private String type;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
