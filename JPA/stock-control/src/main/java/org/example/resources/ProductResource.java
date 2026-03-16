package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import org.example.domain.model.Product;
import org.example.service.ProductService;

import java.util.List;
import java.util.UUID;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductService service;

    @GET
    public List<Product> listAll(){
        return service.listAll();
    }

    @POST
    public void createProduct(Product product){
        service.create(product);
    }

    @PUT
    @Path("/{id}")
    public void updateProduct(@PathParam("id") UUID id, Product product){
        service.update(id, product);
    }

    @GET
    @Path("/{id}")
    public Product findById(@PathParam("id") UUID id){
        return service.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") UUID id){
        service.delete(id);
    }
}