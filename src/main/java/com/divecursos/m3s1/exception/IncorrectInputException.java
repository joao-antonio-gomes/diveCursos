package com.divecursos.m3s1.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IncorrectInputException extends WebApplicationException {

    private String inputName;
    private String identifier;

    public IncorrectInputException(String inputName, String identifier) {
        super(String.format("%s: valor do input incorreto ou não existente: %s", inputName, identifier), Response.Status.BAD_REQUEST);
    }
}
