package fr.saintmartin.yohan.busi.utilities;

import fr.saintmartin.yohan.busi.enumeration.VAT;
import fr.saintmartin.yohan.busi.utilities.annotation.VatValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VatValidator implements ConstraintValidator<VatValues,String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(VatValues constraintAnnotation) {
        acceptedValues = Arrays.stream(VAT.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return acceptedValues.contains(value.toUpperCase());
    }
}
