package com.divecursos.m3s1.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RecordNotFoundException extends WebApplicationException {

    public RecordNotFoundException(String tipoRegistro, String identificador) {
        super(String.format("%s: Registro não encontrado com identificador: %s", tipoRegistro, identificador), Response.Status.NOT_FOUND);
    }
}
