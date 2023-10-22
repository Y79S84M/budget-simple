package fr.saintmartin.yohan.busi.utilities;

import fr.saintmartin.yohan.busi.enumeration.Periodicity;
import fr.saintmartin.yohan.busi.utilities.annotation.PeriodicityValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeriodicityValidator implements ConstraintValidator<PeriodicityValues, String> {
    private List<String> acceptedValues;
    @Override
    public void initialize(PeriodicityValues constraintAnnotation) {
        acceptedValues = Arrays.stream(Periodicity.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return acceptedValues.contains(value.toUpperCase());
    }
}
