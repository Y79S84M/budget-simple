package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.annotation.ValueOfEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@JsonRootName("bank_account_creation")
public class BankAccountCreation extends BankAccountDTO{
    @NotNull(message="Alias must be provided")
    @NotEmpty(message="Alias must not be empty")
    @Length(min = 3, message = "Alias must be at least 3 characters long")
    @Length(max=32, message = "Alias length must not be greater than 32 characters")
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private String balance;
    @NotNull(message = "Type must be provided")
    @NotEmpty(message = "Type must not be empty")
    @ValueOfEnum(listedValues = {AccountType.CURRENT, AccountType.SAVING, AccountType.DEPOSIT})
    @JsonProperty("type")
    private String type;

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getBalance() {
        return balance;
    }

    @Override
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
