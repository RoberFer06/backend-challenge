package com.skytel.challenge.login_backend.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            org.springframework.web.bind.MethodArgumentNotValidException.class,
    })
    @ResponseBody
    public ErrorMessage methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
        return new ErrorMessage(400,errors,"Request message error", request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class
    })
    @ResponseBody
    public ErrorMessage messageNotReadableException(HttpServletRequest request, Exception ex) {
        return new ErrorMessage(400,null, ex.getClass().getSimpleName() ,request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidUserException.class
    })
    @ResponseBody
    public ErrorMessage invalidUser(HttpServletRequest request, InvalidUserException ex) {
        return new ErrorMessage(400,null, ex.getMessage() ,request.getRequestURI());
    }
}
