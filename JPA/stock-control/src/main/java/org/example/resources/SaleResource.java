package org.example.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.domain.model.Sale;
import org.example.service.SaleService;

import java.util.List;
import java.util.UUID;

@Path("/sales")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SaleResource {

    @Inject
    private SaleService saleService;

    @POST
    public Response create(Sale sale) {

        saleService.createSale(sale);

        return Response
                .status(Response.Status.CREATED)
                .entity(sale)
                .build();
    }

    // Buscar venda por ID
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {

        Sale sale = saleService.findById(id);

        return Response.ok(sale).build();
    }

    // Listar vendas
    @GET
    public Response listAll() {

        List<Sale> sales = saleService.listAll();

        return Response.ok(sales).build();
    }

    // Deletar venda
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {

        saleService.delete(id);

        return Response.noContent().build();
    }
}