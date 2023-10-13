package fr.saintmartin.yohan.busi.exception;

import fr.saintmartin.yohan.busi.dto.ErrorRestResponse;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private List<String> errorsDetail;

    @ExceptionHandler(BankAccountNotFoundException.class)
    public final ResponseEntity<ErrorRestResponse> handleEntityNotFoundException(BankAccountNotFoundException ex) {
        errorsDetail = new ArrayList<>();
        String additionalMessage = "The data submitted does not match existing resource.";
        errorsDetail.add(ex.getLocalizedMessage());
        errorsDetail.add(additionalMessage);
        ErrorRestResponse errResp = new ErrorRestResponse("resource not found",errorsDetail,ex.getBkAccInfo(),
                HttpStatus.NOT_FOUND.value(), "Not found");
        return new ResponseEntity<>(errResp,HttpStatus.NOT_FOUND);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        errorsDetail = new ArrayList<>();
        ex.getAllErrors().forEach(err -> errorsDetail.add(err.getDefaultMessage()));
        ErrorRestResponse errResp = new ErrorRestResponse("Impossible to process the request",errorsDetail,request.getDescription(false),
                HttpStatus.BAD_REQUEST.value(), "Bad request");
        return handleExceptionInternal(ex,errResp,headers,HttpStatus.BAD_REQUEST,request);
    }
}
