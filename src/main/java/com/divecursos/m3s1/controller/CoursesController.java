package com.divecursos.m3s1.controller;

import com.divecursos.m3s1.dto.request.CourseReqCreateDTO;
import com.divecursos.m3s1.dto.request.CourseReqUpdateDTO;
import com.divecursos.m3s1.dto.response.CourseRespDTO;
import com.divecursos.m3s1.mapper.CourseMapper;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.service.CourseService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/courses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoursesController {
    @Inject
    private CourseService courseService;

    @POST
    public Response create(@Valid CourseReqCreateDTO courseRequest) {
        Course course = CourseMapper.INSTANCE.toModel(courseRequest);
        Course courseCreated = courseService.create(course);
        CourseRespDTO courseResponse = CourseMapper.INSTANCE.toGenericResponse(courseCreated);
        return Response.created(null).entity(courseResponse).build();
    }

    @GET
    public Response getAll(@QueryParam("sort") String sort, @QueryParam("limit") Integer limit) {
        List<Course> courses = courseService.getAll(sort, limit);
        List<CourseRespDTO> coursesResponse = courses.stream().map(CourseMapper.INSTANCE::toGenericResponse).collect(Collectors.toList());
        return Response.ok(coursesResponse).build();
    }

    @GET
    @Path("/{code}")
    public Response getByCode(@PathParam("code") String code) {
        Course course = courseService.findByCode(code);
        CourseRespDTO courseResponse = CourseMapper.INSTANCE.toGenericResponse(course);
        return Response.ok(courseResponse).build();
    }

    @PUT
    @Path("/{code}")
    public Response update(@PathParam("code") String code, @Valid CourseReqUpdateDTO courseRequest) {
        Course course = CourseMapper.INSTANCE.toModel(courseRequest);
        course.setCode(code);
        Course courseUpdated = courseService.update(course);
        CourseRespDTO courseResponse = CourseMapper.INSTANCE.toGenericResponse(courseUpdated);
        return Response.ok(courseResponse).build();
    }

    @DELETE
    @Path("/{code}")
    public Response delete(@PathParam("code") String code) {
        courseService.deleteByCode(code);
        return Response.noContent().build();
    }
}
