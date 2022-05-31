package com.divecursos.m3s1.controller;

import com.divecursos.m3s1.dto.request.EnrollmentReqCreateDTO;
import com.divecursos.m3s1.dto.response.EnrollmentRespDTO;
import com.divecursos.m3s1.mapper.EnrollmentMapper;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.service.EnrollmentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/enrollments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnrollmentsController {

    @Inject
    private EnrollmentService enrollmentService;

    @POST
    public Response create(@Valid EnrollmentReqCreateDTO enrollmentRequest) {
        Enrollment enrollment = EnrollmentMapper.INSTANCE.toModel(enrollmentRequest);
        enrollmentService.create(enrollment);
        return Response.created(null).build();
    }

    @GET
    public Response getAll() {
        List<Enrollment> enrollmentList = enrollmentService.findAll();
        List<EnrollmentRespDTO> enrollmentRespDTOList = enrollmentList.stream().map(EnrollmentMapper.INSTANCE::toGenericResponse).collect(Collectors.toList());
        return Response.ok(enrollmentRespDTOList).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        enrollmentService.deleteById(id);
        return Response.ok().build();
    }
}
