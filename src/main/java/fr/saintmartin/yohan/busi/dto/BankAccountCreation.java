package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.ValueOfEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@JsonRootName("bank_account_creation")
public class BankAccountCreation {
    @NotNull(message="Alias must be provided")
    @NotEmpty(message="Alias must not be empty")
    @Length(min = 3, message = "Alias must be at least 3 characters long")
    @Length(max=32, message = "Alias length must not be greater than 32 characters")
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private double balance;
    @NotNull(message = "Type must be provided")
    @NotEmpty(message = "Type must not be empty")
    @ValueOfEnum(listedValues = {AccountType.CURRENT, AccountType.SAVING, AccountType.DEPOSIT})
    @JsonProperty("type")
    private String type;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
