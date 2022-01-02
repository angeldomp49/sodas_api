
package com.makechtec.angel.sodas;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.BaseModel;
import models.Soda;

import org.json.simple.JSONObject;

@Path("soda/{soda}")
@RequestScoped
public class SodaResource {

    @Context
    private UriInfo context;

    public SodaResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String show(@PathParam("soda") int id) {        
        Soda soda = (Soda) BaseModel.withClass(Soda.class).show(id);
        JSONObject encodedObj = new JSONObject();
        
        encodedObj.put("id", soda.getId());
        encodedObj.put("marca", soda.getMarca());
        encodedObj.put("sabor", soda.getSabor());
        encodedObj.put("descripcion", soda.getDescripcion());
        return encodedObj.toJSONString();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String store( MultivaluedMap<String, String> formData ){
        String description = formData.getFirst("description");
        String flavor = formData.getFirst("flavor");
        String marca = formData.getFirst("marca");
        return "{response: resource created}";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("soda") int id) {
        return "{response: resource updated}";
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String destroy(@PathParam("soda") int id) {
        return "{response: successful deleted}";
    }
}
