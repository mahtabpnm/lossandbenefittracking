package dev.tracking.lossandbenefit.exception;

public class TransactionNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;
    public TransactionNotFoundException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode(){
        return errorCode;
    }
}
