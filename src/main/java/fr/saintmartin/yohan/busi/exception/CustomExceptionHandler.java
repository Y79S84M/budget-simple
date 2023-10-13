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

    private final List<String> errorsDetail = new ArrayList<>();

    @ExceptionHandler(BankAccountNotFoundException.class)
    public final ResponseEntity<ErrorRestResponse> handleEntityNotFoundException(BankAccountNotFoundException ex) {
        String additionalMessage = "The data submitted does not match existing resource.";
        errorsDetail.add(ex.getLocalizedMessage());
        errorsDetail.add(additionalMessage);
        ErrorRestResponse errResp = new ErrorRestResponse("resource not found",errorsDetail,ex.getBkAccInfo(),
                HttpStatus.NOT_FOUND.value(), "Not found");
        return new ResponseEntity<>(errResp,HttpStatus.NOT_FOUND);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        errorsDetail.add(ex.getDetailMessageCode());
        ErrorRestResponse errResp = new ErrorRestResponse("Impossible to process the request",errorsDetail,request.toString(),
                HttpStatus.BAD_REQUEST.value(), "Bad request");
        return handleExceptionInternal(ex,errResp,headers,HttpStatus.BAD_REQUEST,request);
    }
}
