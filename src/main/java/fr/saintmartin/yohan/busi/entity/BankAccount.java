package fr.saintmartin.yohan.busi.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accId;

    private String alias;
    private double balance;
    @OneToMany(mappedBy = "bankAccount")
    private List<FinancialTransaction> ftList;

    public UUID getAccId() {
        return accId;
    }

    public void setAccId(UUID accId) {
        this.accId = accId;
    }

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

    public List<FinancialTransaction> getFtList() {
        return ftList;
    }

    public void setFtList(List<FinancialTransaction> ftList) {
        this.ftList = ftList;
    }
}
