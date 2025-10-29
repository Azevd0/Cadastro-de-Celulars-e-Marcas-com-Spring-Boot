package com.SpringPhone.Cellphone.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String mensage, String path) {
        super(timestamp, status, mensage, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String defaultMessage, String field) {
        this.errors.add(new FieldMessage(field, defaultMessage));
    }
}
