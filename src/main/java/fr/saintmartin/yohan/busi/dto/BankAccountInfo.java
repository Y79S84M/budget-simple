package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("bank_account_info")
public class BankAccountInfo {
    @JsonProperty("bank_account_id")
    private String accId;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("balance")
    private String balance;
    @JsonProperty("type")
    private String type;

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
}
