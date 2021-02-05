package com.sahandm96.dox.exHandler;

import com.sahandm96.dox.helper.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MessageService messageService;

    public GeneralExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        log.error("Exception occurred:", ex);
        String msg = messageService.get("exception.occurred");

        ErrorResponse errorReponse = new ErrorResponse(msg);
        return new ResponseEntity<>(errorReponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public final ResponseEntity<Object> handleSecurityException(Exception ex, WebRequest request) throws Exception {
        return super.handleException(ex, request);
    }


    @ExceptionHandler(value = {CustomException.class})
    public final ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
        String msg = messageService.get(((CustomException) ex).getCode(), ((CustomException) ex).getArgs());
        ErrorResponse errorResponse = new ErrorResponse(msg);
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);

    }

}

