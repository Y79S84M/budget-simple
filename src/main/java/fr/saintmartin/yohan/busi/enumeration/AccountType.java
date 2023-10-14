package fr.saintmartin.yohan.busi.enumeration;
import fr.saintmartin.yohan.busi.utilities.ValueOfEnum;

import java.lang.annotation.Annotation;

public enum AccountType implements Annotation {
    CURRENT,
    SAVING,
    DEPOSIT;

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public Class<? extends Annotation> annotationType(){
        return ValueOfEnum.class;
    }
}
