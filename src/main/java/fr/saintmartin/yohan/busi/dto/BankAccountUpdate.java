package fr.saintmartin.yohan.busi.dto;

import fr.saintmartin.yohan.busi.enumeration.AccountType;

public class BankAccountUpdate {
    private String alias;
    private AccountType type;

    public BankAccountUpdate(String alias, AccountType type) {
        this.alias = alias;
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
