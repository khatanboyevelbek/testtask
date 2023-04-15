package com.furprprogress.testtask;

import com.furprprogress.testtask.application.ProductService;
import com.furprprogress.testtask.domain.DTOs.ProductDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/products")
public class ProductApplication {

    private final ProductService productService;

    @Inject
    public ProductApplication(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<ProductDto> productDtos = productService.getAllProducts();

        return Response.ok(productDtos).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") UUID id) {
        ProductDto productDto = productService.getProductById(id);

        if(productDto != null)
        {
            return Response.ok(productDto).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDto productDto) {
        if(productDto != null)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        productService.createProduct(productDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") UUID id, ProductDto productDto) {
        if(id == null && productDto == null)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        productService.updateProduct(id, productDto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProductById(@PathParam("id") UUID id) {
        if(id == null)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        productService.deleteProductById(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}