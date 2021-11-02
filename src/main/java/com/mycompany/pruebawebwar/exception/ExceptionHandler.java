/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.exception;

import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception ex) {
         ex.printStackTrace();
         ExcepionWrraper wrraper;
        if(ex instanceof BussinessException || ex instanceof ArrayIndexOutOfBoundsException) {
             wrraper = new ExcepionWrraper("400", "BAD_REQUEST", ex.getMessage(),
                    "/estudiantes/obtener");    
            return Response.status(Response.Status.BAD_REQUEST).entity(wrraper).build();
        } else if(ex instanceof ResourceNotFoundException){
            wrraper = new ExcepionWrraper("404", "NOT_FOUND", ex.getMessage(),
                    "/estudiantes/obtener");    
             return Response.status(Response.Status.NOT_FOUND).entity(wrraper).build();
        } else {
              wrraper = new ExcepionWrraper("500", "INTERNAL_SERVER_ERROR", "",
                    "/estudiantes/obtener");    
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build();
        } 
    }
}
