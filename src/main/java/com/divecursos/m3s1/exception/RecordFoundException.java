package com.divecursos.m3s1.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RecordFoundException extends WebApplicationException {

    public RecordFoundException(String tipoRegistro, String identificador) {
        super(String.format("%s: Registro existente com identificador: %s", tipoRegistro, identificador), Response.Status.CONFLICT);
    }
}
