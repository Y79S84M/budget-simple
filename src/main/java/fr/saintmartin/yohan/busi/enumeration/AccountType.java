package fr.saintmartin.yohan.busi.enumeration;
import fr.saintmartin.yohan.busi.utilities.annotation.ValueOfEnum;

import java.lang.annotation.Annotation;

public enum AccountType implements Annotation {
    CURRENT,
    SAVING,
    DEPOSIT;

    @Override
    public Class<? extends Annotation> annotationType(){
        return ValueOfEnum.class;
    }
}
