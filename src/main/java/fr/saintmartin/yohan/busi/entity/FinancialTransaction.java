package fr.saintmartin.yohan.busi.entity;

import fr.saintmartin.yohan.busi.enumeration.PaymentMethod;
import fr.saintmartin.yohan.busi.enumeration.Periodicity;
import fr.saintmartin.yohan.busi.enumeration.VAT;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="financial_transaction")
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ftId;
    private UUID uuid;
    private LocalDate date;
    private String recipient;
    private String description;
    private PaymentMethod paymentMethod;
    private Periodicity periodicity;
    private VAT vat;
    private double inclVatAmount;
    private double exclVatAmount;
    @ManyToOne
    private BankAccount bankAccount;

    private LocalDate createdOn;
    private LocalDate updatedOn;
    private LocalDate deletedOn;
    private boolean deleted = Boolean.FALSE;

    public Long getFtId() {
        return ftId;
    }

    public void setFtId(Long ftId) {
        this.ftId = ftId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public double getInclVatAmount() {
        return inclVatAmount;
    }

    public void setInclVatAmount(double inclVatAmount) {
        this.inclVatAmount = inclVatAmount;
    }

    public double getExclVatAmount() {
        return exclVatAmount;
    }

    public void setExclVatAmount(double exclVatAmount) {
        this.exclVatAmount = exclVatAmount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDate getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDate deletedOn) {
        this.deletedOn = deletedOn;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
