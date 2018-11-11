package com.adidas.challenge.common.exceptions;

import com.adidas.challenge.common.data.output.ModelError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Throwable cause(Throwable t) {
        Throwable cause = t.getCause();
        return cause == null ? t : cause(cause);
    }

    private ModelError error(HttpStatus status, String message) {
        return new ModelError(status.value(), new Date(), message);
    }

    private ResponseEntity<ModelError> entity(HttpStatus status, String message) {
        return new ResponseEntity<>(error(status, message), status);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ModelError> generic(HttpServletRequest request, Exception ex) {
        ex.printStackTrace();
        return entity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ModelError> arguments(HttpServletRequest request, IllegalArgumentException ex) {
        ex.printStackTrace();
        return entity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ModelError> duplicate(HttpServletRequest request, DataIntegrityViolationException ex) {
        ex.printStackTrace();
        Throwable cause = cause(ex);
        if (cause instanceof SQLIntegrityConstraintViolationException) {
            return entity(HttpStatus.BAD_REQUEST, "some content already exists in another entry");
        } else {
            return entity(HttpStatus.BAD_REQUEST, "duplicate entry");
        }
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ModelError> duplicate(HttpServletRequest request, ConstraintViolationException ex) {
        ex.printStackTrace();
        return entity(HttpStatus.BAD_REQUEST, "duplicate entry");
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ModelError> notFound(HttpServletRequest request, NotFoundException ex) {
        ex.printStackTrace();
        return entity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

}
