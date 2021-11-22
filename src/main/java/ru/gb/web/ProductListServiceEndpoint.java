package ru.gb.web;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gb.entities.Product;
import ru.gb.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ProductListServiceEndpoint {
    public static final String NAMESPACE_URI = "http://gb.ru/web";

    private final ProductRepository repository;

    public ProductListServiceEndpoint(ProductRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductResponse(@RequestPayload GetProductRequest getProductRequest) {
        GetProductResponse response = new GetProductResponse();
        List<Product> productListDB = new ArrayList<>();
        repository.findAll().forEach(productListDB::add);
        for (Product value : productListDB) {
            ProductResponse product = new ProductResponse();
            product.setId(value.getId());
            product.setName(value.getName());
            product.setPrice(value.getPrice());
            response.getProductList().add(product);
        }
        return response;
    }


}
