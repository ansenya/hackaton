package ru.packetSolution.hack.data.api.products;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.packetSolution.hack.domain.model.Product;

public interface ProductsApi {
    @GET("/product")
    Call<List<Product>> getProducts();

    @GET("product/{id}")
    Call<Product> getProduct(
            @Path("id")
            long id
    );
    @DELETE("product/{id}")
    Call<Void> deleteProduct(
            @Path("id")
            long id
    );
}
