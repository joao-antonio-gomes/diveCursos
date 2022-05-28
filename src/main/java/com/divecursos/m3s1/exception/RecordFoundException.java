package com.divecursos.m3s1.exception;

public class RecordFoundException extends Exception {

    private String tipoRegistro;
    private String identificador;

    public RecordFoundException(String tipoRegistro, String identificador) {
        this.tipoRegistro = tipoRegistro;
        this.identificador = identificador;
    }

    public String getMessage() {
        return String.format("%s: Registro existente com identificador: %s", tipoRegistro, identificador);
    }
}
