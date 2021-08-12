package com.nn.basket.exception;

import com.nn.basket.controller.BasketController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Handles the exception thrown from Movies Controlle
 *
 * @author Revathir
 */
@RestControllerAdvice(assignableTypes = {BasketController.class})
public class BasketControllerExceptionAdvice {
    /**
     * Receives MovieHttpException
     * @param ex MovieHttpException
     * @return response Message with http status
     */
    @ExceptionHandler({BasketHttpException.class})
    public ResponseEntity<String> handleBasketHttpException(BasketHttpException ex) {

        HttpStatus status = HttpStatus.resolve(ex.getHttpStatus());
        if(status == null) status = INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(ex.getMessage(), status);
    }


    /**
     * For ConstraintViolationException
     *
     * @param ex exception
     * @return ExceptionResponse Object
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
