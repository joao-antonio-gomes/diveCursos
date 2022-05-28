package com.divecursos.m3s1.exception;

public class IncorrectInputException extends Exception {

    private String inputName;
    private String identifier;

    public IncorrectInputException(String inputName, String identifier) {
        this.inputName = inputName;
        this.identifier = identifier;
    }

    public String getMessage() {
        return String.format("%s: valor do input incorreto ou não existente: %s", inputName, identifier);
    }
}
