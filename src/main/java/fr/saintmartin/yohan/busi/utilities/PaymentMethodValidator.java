package fr.saintmartin.yohan.busi.utilities;

import fr.saintmartin.yohan.busi.enumeration.PaymentMethod;
import fr.saintmartin.yohan.busi.utilities.annotation.PaymentMethodValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentMethodValidator implements ConstraintValidator<PaymentMethodValues, String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(PaymentMethodValues constraintAnnotation) {
        acceptedValues = Arrays.stream(PaymentMethod.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return acceptedValues.contains(value.toUpperCase());
    }
}
