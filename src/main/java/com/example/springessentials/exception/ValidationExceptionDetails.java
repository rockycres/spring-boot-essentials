package com.example.springessentials.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ValidationExceptionDetails extends ExceptionDetails{

    private String fields;
    private String fieldsMessage;
}
