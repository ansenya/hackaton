package ru.packetSolution.hack.data.repository;

import java.util.List;

import retrofit2.Call;
import ru.packetSolution.hack.data.api.products.ProductsApiService;
import ru.packetSolution.hack.data.api.users.UsersApiService;
import ru.packetSolution.hack.domain.model.Product;
import ru.packetSolution.hack.domain.model.User;

public class ProductsRepository {
    public static Call<List<Product>> getProducts(){
        return ProductsApiService.getInstance().getProducts();
    }
    public static Call<Product> getProduct(int id){
        return ProductsApiService.getInstance().getProduct(id);
    }
    public static Call<Void> deleteProduct(int id){
        return ProductsApiService.getInstance().deleteProduct(id);
    }

}
