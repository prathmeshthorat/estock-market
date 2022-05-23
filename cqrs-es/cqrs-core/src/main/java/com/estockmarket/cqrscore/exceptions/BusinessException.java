package com.estockmarket.cqrscore.exceptions;

import java.util.List;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private int httpCode;
    private ErrorCodesIF errorCode;
    private List<Error> errors;

    public BusinessException(ErrorCodesIF errorCode, List<Error> errors) {
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = this.errorCode.getCode();
    }

    public ErrorCodesIF getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(ErrorCodesIF errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = this.errorCode.getMessage();
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = this.errorCode.getHttpCode();
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "BusinessException [code=" + code + ", errorCode=" + errorCode + ", errors=" + errors + "]";
    }

}
