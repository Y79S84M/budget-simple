package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.saintmartin.yohan.busi.enumeration.PaymentMethod;
import fr.saintmartin.yohan.busi.enumeration.Periodicity;
import fr.saintmartin.yohan.busi.enumeration.VAT;
import fr.saintmartin.yohan.busi.utilities.annotation.PaymentMethodValues;
import fr.saintmartin.yohan.busi.utilities.annotation.PeriodicityValues;
import fr.saintmartin.yohan.busi.utilities.annotation.VatValues;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FinancialTransactionUpdate extends FinancialTransactionDTO {
    @NotBlank
    @JsonProperty("bank_account_id")
    private String bankAccId;
    @NotBlank
    @JsonProperty("date")
    private String date;
    @NotBlank
    private String recipient;
    @NotNull
    private String description;
    @NotNull
    @PaymentMethodValues(
            enumValues = {
                    PaymentMethod.BANK_TRANSFER,
                    PaymentMethod.CASH,
                    PaymentMethod.CREDIT_CARD,
                    PaymentMethod.DEBIT_CARD,
                    PaymentMethod.DIRECT_DEBIT
            }
    )
    @JsonProperty("payment_method")
    private String paymentMethod;
    @NotBlank
    private String amount;
    @NotNull
    @VatValues(
            enumValues = {
                    VAT.ZERO,
                    VAT.TWO_ONE,
                    VAT.FIVE_FIVE,
                    VAT.TEN,
                    VAT.TWENTY
            }
    )
    private String vat;
    @NotNull
    @PeriodicityValues(
            enumValues = {
                    Periodicity.NONE,
                    Periodicity.WEEKLY,
                    Periodicity.MONTHLY,
                    Periodicity.BIMONTHLY,
                    Periodicity.QUARTERLY,
                    Periodicity.BIANNUAL,
                    Periodicity.YEARLY
            }
    )
    private String periodicity;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("updated_on")
    private String updatedOn;

    public String getBankAccId() {
        return bankAccId;
    }

    public void setBankAccId(String bankAccId) {
        this.bankAccId = bankAccId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
