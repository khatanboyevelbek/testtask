package com.furprprogress.testtask;

import com.furprprogress.testtask.application.interfaces.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.furprprogress.testtask.domain.model.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
public class ProductResources {
    private final ProductService productService;

    @Inject
    public ProductResources(ProductService productService)
    {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") long id) {
        return productService.getProductById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertProduct(Product product) {
        productService.addProduct(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") long id, Product product) {
        productService.updateProduct(id, product);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProductById(@PathParam("id") long id) {
        productService.deleteProductById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}