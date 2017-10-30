package com.msa.user.controller.exception;

import com.msa.common.controller.exception.BaseExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientConnectionException;

@ControllerAdvice("com.msa.user.controller")
@Slf4j
public class ControllerExceptionHandler extends BaseExceptionHandler {
}
