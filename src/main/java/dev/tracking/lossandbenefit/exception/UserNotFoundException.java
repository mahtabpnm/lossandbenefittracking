package dev.tracking.lossandbenefit.exception;


public class UserNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;
    public UserNotFoundException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode(){
        return errorCode;
    }
}