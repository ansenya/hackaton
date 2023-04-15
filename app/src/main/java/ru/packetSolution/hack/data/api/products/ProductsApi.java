package ru.packetSolution.hack.data.api.products;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.packetSolution.hack.model.Product;

public interface ProductsApi {
    @GET("/product")
    Call<List<Product>> getProducts();
}
