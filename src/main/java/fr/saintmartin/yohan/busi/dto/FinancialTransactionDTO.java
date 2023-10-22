package fr.saintmartin.yohan.busi.dto;

public abstract class FinancialTransactionDTO {
    protected String ftId;
    protected String date;
    protected String recipient;
    protected String description;
    protected String paymentMethod;
    protected String amount;
    protected String periodicity;

}
