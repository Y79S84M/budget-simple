package fr.saintmartin.yohan.busi.utilities;

import fr.saintmartin.yohan.busi.enumeration.AccountType;
import fr.saintmartin.yohan.busi.utilities.annotation.AccountTypeValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccountTypeValidator implements ConstraintValidator<AccountTypeValues, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(AccountTypeValues constraintAnnotation) {
        acceptedValues = Arrays.stream(AccountType.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return acceptedValues.contains(value.toUpperCase());
    }
}
