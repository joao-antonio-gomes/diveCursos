package com.divecursos.m3s1.exception;

public class RecordNotFoundException extends Exception {

    private String tipoRegistro;
    private String identificador;

    public RecordNotFoundException(String tipoRegistro, String identificador) {
        this.tipoRegistro = tipoRegistro;
        this.identificador = identificador;
    }

    public String getMessage() {
        return String.format("%s: Registro não encontrado com identificador: %s", tipoRegistro, identificador);
    }
}
