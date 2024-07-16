package dev.tracking.lossandbenefit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException (UserNotFoundException ex){
        return buildErrorResponse(ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException (TransactionNotFoundException ex){
        return buildErrorResponse(ErrorCode.TRANSACTION_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException (Exception ex){
        return buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(ErrorCode errorCode, HttpStatus httpStatus) {
        ErrorResponse errorResponse =new ErrorResponse(errorCode,errorCode.getMessage());
        return new ResponseEntity<>(errorResponse,httpStatus);
    }
}
