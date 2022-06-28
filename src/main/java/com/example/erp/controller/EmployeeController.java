package com.example.erp.controller;

import com.example.erp.bean.Employee;

import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.query.Query;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("employee")
public class EmployeeController {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginEmployee(Employee employee) throws URISyntaxException {

        System.out.println(employee.getEmail());
        System.out.println("hi");

        List<Employee> emps = new ArrayList<>();

        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Employee where email=:email");
            query.setParameter("email", employee.getEmail());
            for (final Object emp : query.list()) {
                emps.add((Employee) emp);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }

        //Employee result= emps.get(0);
        //System.out.println(emps.get(0).getFirst_name());

        //if(result == null){
          //  return Response.noContent().build();
        //}
        System.out.println(emps.size());
        if(emps.size()>=1)
        return Response.ok().build();
        else
            return Response.noContent().build();



    }



}

