package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonRootName("bank_account_creation")
public class BankAccountCreation {
    @NotNull
    @NotEmpty
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private double balance;
    @NotNull
    @NotEmpty
    @JsonProperty("type")
    private String bankAccountType;

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

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }
}
