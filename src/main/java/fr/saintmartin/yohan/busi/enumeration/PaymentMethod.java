package fr.saintmartin.yohan.busi.enumeration;

public enum PaymentMethod {
    BANK_TRANSFER("Bank transfer"),
    CASH("Cash"),
    CREDIT_CARD("Credit card"),
    DEBIT_CARD("Debit card"),
    DIRECT_DEBIT("Direct debit");
    private final String label;
    PaymentMethod(String label) {
        this.label = label;
    }
    public String label(){
        return this.label;
    }
}
