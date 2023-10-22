package fr.saintmartin.yohan.busi.enumeration;

import fr.saintmartin.yohan.busi.utilities.annotation.VatValues;

import java.lang.annotation.Annotation;

public enum VAT implements Annotation {
    ZERO(0.0),
    TWO_ONE(2.1),
    FIVE_FIVE(5.5),
    TEN(10.0),
    TWENTY(20.0);
    private final double rate;
    VAT(double rate){
        this.rate = rate;
    }
    public double rate(){
        return this.rate;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return VatValues.class;
    }
}
