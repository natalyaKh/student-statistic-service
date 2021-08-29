package com.student.statisticservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Exception Handler
 * throw exceptions ->
 * HttpStatus.INTERNAL_SERVER_ERROR
 */
@RestControllerAdvice
public class StatisticExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDto exceptionHandler(Exception ex) {
        LOGGER.warn(ex.getMessage());
        LOGGER.warn(ex.getClass().getName());
        return ErrorDto.builder()
            .date(LocalDateTime.now())
            .error(ex.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .build();
    }
}
