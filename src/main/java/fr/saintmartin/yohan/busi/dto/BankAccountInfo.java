package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccountInfo extends BankAccountDTO {
    @JsonProperty("bank_account_id")
    private String accId;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private String balance;
    @JsonProperty("type")
    private String type;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    private String updatedOn;

    public String getAccId() {
        return accId;
    }

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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(String updatedOn) { this.updatedOn = updatedOn; }
}
