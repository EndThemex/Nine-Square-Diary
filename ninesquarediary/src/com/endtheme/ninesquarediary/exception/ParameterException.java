package com.endtheme.ninesquarediary.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -3711088672030241126L;

    Map<String, String> errorField = new HashMap<String, String>();

    public Map<String, String> getErrorField() {
        return errorField;
    }

    public void setErrorField(Map<String, String> errorField) {
        this.errorField = errorField;
    }

    public void addErrorField(String fieldName, String message) {
        errorField.put(fieldName, message);
    }

    public boolean isErrorField() {
        return !errorField.isEmpty();
    }

}
