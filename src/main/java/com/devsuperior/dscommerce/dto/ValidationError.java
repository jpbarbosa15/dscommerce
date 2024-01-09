package com.devsuperior.dscommerce.dto;

import org.aspectj.bridge.IMessage;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrorCustom {
    private List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName,message ));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public ValidationError(Instant timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
    }
}
