/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.controller;

import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import com.mycompany.pruebawebwar.exception.ExcepionWrraper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import co.edu.unicundi.pruebaejbjar.service.IAlumnoService;

/**
 * Controllador para recibir las peticiones de todo lo que tiene que ver con estudiantes
 * @author Johans
 * @version 1.0
 * @since 12/08/2021
 */

@Stateless
@Path("/pruebas")
public class PruebaController {
    
    @EJB
    private IAlumnoService service;
    
    /*@GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtener(){
            EstudianteService estService = new EstudianteService();
            try {
              estService.metodo();
              return Response.status(Response.Status.OK).build();
            } catch(ArrayIndexOutOfBoundsException e) {
              System.out.println("Entro a exception");
              e.printStackTrace();
              ExcepionWrraper wrraper = new ExcepionWrraper("500", "INTERNAL_SERVER_ERROR", "",
                      "/estudiantes/obtener");

              return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build();
            }
    }
    
    @GET
    @Path("/obtener2/{indice}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtener2(@Min(3) @Max(12) @PathParam("indice") int indice) 
            throws BussinessException, ArrayIndexOutOfBoundsException, Exception{
          EstudianteService estService = new EstudianteService();
          estService.metodo2(indice);
          return Response.status(Response.Status.OK).build();
    }   */
    
    
    
    @GET
    @Path("/obtenerListaPorSemestre/{semestre}/{genero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerLista(   @PathParam("semestre") String semestre,
                                        @PathParam("genero") String genero){
        System.out.println(semestre + " " + genero);
        List<String> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add("Johans");
        listaEstudiantes.add("Andrea");
        listaEstudiantes.add("Juan");
        if(!listaEstudiantes.isEmpty()){
            return Response.status(Response.Status.OK).entity(listaEstudiantes)
                   .header("TipoDato", "Lista de objeto").build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }   
    
   /* @GET
    @Path("/obtenerGson")
    @Produces(MediaType.APPLICATION_JSON)
    public EstudianteDto obtenerGson(){
        List<String> listaMateria = new ArrayList<>();
        listaMateria.add("Programacion I");
        listaMateria.add("Auditoria");
        listaMateria.add("SI");
        int[] vector = {1, 2, 3, 4};
        EstudianteDto ob = new EstudianteDto("1070", "Johans",  "Gonzalez", 25, "johans-123@hotmail.com", listaMateria, vector);
        return ob;
    } */  
    
    
    
    /*@POST
    @Path("/insertarPrueba")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public Response insertarPrueba(EstudianteDto estudaiante){
        System.out.println("Registrado correctamente " + estudaiante.getNombre());
        System.out.println("Registrado correctamente " + estudaiante.getApellido());
        System.out.println("Registrado correctamente " + estudaiante.getCedula());
        System.out.println("Registrado correctamente " + estudaiante.getCorreo());
        System.out.println("Registrado correctamente " + estudaiante.getEdad());
        System.out.println(estudaiante.toString());
        return Response.status(Response.Status.CREATED).build();
        //return Response.ok(this);
    }
    
    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public Response insertar( EstudianteDto estudaiante){
        System.out.println("Registrado correctamente"  + estudaiante.getNombre());
        
         return Response.status(Response.Status.CREATED).build();
        //return listaEstudiantes;
    }   */
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public void editar(List<String> listaEstudiantes){
        for (String le : listaEstudiantes) {
            System.out.println(le);
        }
        System.out.println("Registrado editado correctamente");
        //return listaEstudiantes;
    }   
      
    @DELETE
    @Path("/eliminarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void elminarPorId(   @PathParam("id") int id){
        System.out.println(id);
    }     
    
    
    @GET
    @Path("/obtenerEJB")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerEJB(){
            
        service.listar();
        return Response.status(Response.Status.OK).build();
    }    
    
}