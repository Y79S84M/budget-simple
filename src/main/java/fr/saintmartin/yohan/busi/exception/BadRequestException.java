package fr.saintmartin.yohan.busi.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class BadRequestException extends MethodArgumentNotValidException {
    public BadRequestException(MethodParameter methodParameter, BindingResult bindingResult) {
        super(methodParameter,bindingResult);
    }
}
