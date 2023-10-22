package fr.saintmartin.yohan.busi.enumeration;

import fr.saintmartin.yohan.busi.utilities.annotation.PaymentMethodValues;

import java.lang.annotation.Annotation;

public enum PaymentMethod implements Annotation {
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

    @Override
    public Class<? extends Annotation> annotationType() {
        return PaymentMethodValues.class;
    }
}
