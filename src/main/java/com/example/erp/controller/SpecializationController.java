package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Specialization;
import com.example.erp.service.SpecializationService;
import org.glassfish.jersey.media.multipart.FormDataParam;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

@Path("specialization")
public class SpecializationController {
    SpecializationService specializationService = new SpecializationService();

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerSpecialization(Specialization specialization) throws URISyntaxException {

        if(specializationService.registerSpecialization(specialization)){
            return Response.ok().build();
        }
        return Response.status(203).build();
    }

    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpecialization() {
        List<Specialization> specialization = specializationService.readSpecialization();
        return Response.ok().entity(specialization).build();
    }


    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSpecialization(Specialization specialization) throws URISyntaxException {

        if(specializationService.updateSpecialization(specialization)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }

    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSpecialization(Specialization specialization) throws URISyntaxException {

        if(specializationService.deleteSpecialization(specialization)){
            return Response.ok().build();
        }
        return Response.status(203).build();



    }

    @GET
    @Path("/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchSpecialization() {
        List<Specialization> specialization = specializationService.fetchSpecialization();
        //List<Courses> course =new ArrayList<>() ;
        int x= specialization.size();
        int[] a = new int[x];


         Map<String, Integer> map = new HashMap<>();

        for (Specialization spec : specialization) {
           List<Courses> course = spec.getCourses();
            int i=0;
            for(Courses c: course)
            {
                i++;
            }
           map.put(spec.getName(),i);
            course.clear();

        }
        //TreeMap<String, Integer> sorted = new TreeMap<>(map);
        //sorted.putAll(map);

        
        return Response.ok().entity(map).build();
    }


  /*  @POST
    @Path("/joinreg")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response joinregSpecialization(@FormDataParam("code") String code,
                                          @FormDataParam("name") String name,
                                          @FormDataParam("description") String description,
                                          @FormDataParam("year") String year,
                                          @FormDataParam("credits") Integer credits) throws URISyntaxException {

        List<Courses> course = specialization.getCourses();
        specialization.setCourses(course);

        if(specializationService.joinregSpecialization(specialization)){
            return Response.ok().build();
        }
        return Response.status(203).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerCourse(@FormDataParam("name") String name,
                                   @FormDataParam("description") String description,
                                   @FormDataParam("credits") Integer credits) throws URISyntaxException {
        System.out.println(name);
        System.out.println(description);
        System.out.println(credits);
        return Response.ok().build();

    }*/


}

