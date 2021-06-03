package com.example.apijavaspringboot.exception;

import java.util.Map;

public class ErrorInfo {

    private String url;

    private String message;

    private Map<String, String> errors;

    private int errorCode;

    private Throwable ex;

    public ErrorInfo() {
    }

    public ErrorInfo(String url, String message, int errorCode) {
        this();
        this.url = url;
        this.message = message;
        this.errorCode = errorCode;
    }

    public ErrorInfo(String url, String message, Map<String, String> errors, int errorCode) {
        this(url, message, errorCode);
        this.errors = errors;
    }

    public ErrorInfo(String url, String message, Map<String, String> errors, int errorCode, Throwable ex) {
        this(url, message, errors, errorCode);
        this.ex = ex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Throwable getEx() {
        return ex;
    }

    public void setEx(Throwable ex) {
        this.ex = ex;
    }
}
