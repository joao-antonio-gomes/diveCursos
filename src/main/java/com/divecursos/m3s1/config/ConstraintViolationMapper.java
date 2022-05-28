package com.divecursos.m3s1.config;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<String> messages = violations.stream().map(ConstraintViolation::getMessage).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return Response.status(Response.Status.BAD_REQUEST).entity(messages).build();
    }
}
