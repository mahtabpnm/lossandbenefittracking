package dev.tracking.lossandbenefit.exception;

public enum ErrorCode {

    USER_NOT_FOUND("User not found"),
    TRANSACTION_NOT_FOUND("Transaction not found"),
    INTERNAL_SERVER_ERROR("AN unexpected error occurred");

    private final String message;

    ErrorCode(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}
