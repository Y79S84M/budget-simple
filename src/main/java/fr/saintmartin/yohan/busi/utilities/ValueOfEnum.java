package fr.saintmartin.yohan.busi.utilities;

import fr.saintmartin.yohan.busi.enumeration.AccountType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    AccountType[] listedValues();
    String message() default "Type must be one of the following values {listedValues}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
