package com.endtheme.ninesquarediary.exception;

public class ServiceException extends Exception {


    /**
     *
     */
    private static final long serialVersionUID = 8766896731798597016L;

    private int code;
    private String message;

    public ServiceException() {
        super();
    }

    public ServiceException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
