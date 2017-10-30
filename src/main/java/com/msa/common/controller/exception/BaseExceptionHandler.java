package com.msa.common.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientConnectionException;

@Slf4j
public class BaseExceptionHandler {
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Data integrity violation")
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class, DataIntegrityViolationException.class})
    public void integrityConstraintViolationExceptionHandler(HttpServletRequest request) {
        log.error("IntegrityConstraintViolationException occurred !!!");
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Database connection problem")
    @ExceptionHandler({SQLNonTransientConnectionException.class})
    public void connectionExceptionHandler(HttpServletRequest request) {
        log.error("NonTransientConnectionException occurred !!!");
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Exception occurred")
    @ExceptionHandler({Exception.class})
    public void allExceptionHandler(Exception ex, HttpServletRequest request) {
        log.error("Exception occurred !!! : {}", ex.getMessage());
    }
}
