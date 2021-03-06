package com.divecursos.m3s1.controller;

import com.divecursos.m3s1.dto.request.StudentReqCreateDTO;
import com.divecursos.m3s1.dto.request.StudentReqUpdateDTO;
import com.divecursos.m3s1.dto.response.StudentRespDTO;
import com.divecursos.m3s1.mapper.StudentMapper;
import com.divecursos.m3s1.model.entity.Student;
import com.divecursos.m3s1.service.StudentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentsController {
    @Inject
    private StudentService studentService;

    @POST
    public Response create(@Valid StudentReqCreateDTO studentRequest) {
        Student student = StudentMapper.INSTANCE.toModel(studentRequest);
        Student studentCreated = studentService.create(student);
        StudentRespDTO studentResponse = StudentMapper.INSTANCE.toGenericResponse(studentCreated);
        return Response.status(Response.Status.CREATED).entity(studentResponse).build();
    }

    @GET
    public Response findAll(@QueryParam("name") String name) {
        List<Student> studentsFound = studentService.findAll(name);
        List<StudentRespDTO> studentsResponse = studentsFound.stream()
                .map(StudentMapper.INSTANCE::toGenericResponse)
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(studentsResponse).build();
    }

    @GET
    @Path("/{register}")
    public Response getByCode(@PathParam("register") Integer register) {
        Student studentFound = studentService.findByRegister(register);
        StudentRespDTO studentResponse = StudentMapper.INSTANCE.toGenericResponse(studentFound);
        return Response.status(Response.Status.OK).entity(studentResponse).build();
    }

    @PUT
    @Path("/{register}")
    public Response update(@PathParam("register") String register, @Valid StudentReqUpdateDTO courseRequest) {
        Student student = StudentMapper.INSTANCE.toModel(courseRequest);
        student.setRegister(Integer.parseInt(register));
        Student studentUpdated = studentService.update(student);
        StudentRespDTO studentResponse = StudentMapper.INSTANCE.toGenericResponse(studentUpdated);
        return Response.status(Response.Status.OK).entity(studentResponse).build();
    }

    @DELETE
    @Path("/{register}")
    public Response delete(@PathParam("register") String register) {
        studentService.deleteByRegister(Integer.parseInt(register));
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
