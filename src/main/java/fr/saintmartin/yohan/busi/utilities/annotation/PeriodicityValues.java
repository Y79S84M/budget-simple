package fr.saintmartin.yohan.busi.utilities.annotation;

import fr.saintmartin.yohan.busi.enumeration.Periodicity;
import fr.saintmartin.yohan.busi.utilities.PeriodicityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PeriodicityValidator.class)
public @interface PeriodicityValues {
    Periodicity[] enumValues();
    String message() default "Type must be one of the following values: {enumValues}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
