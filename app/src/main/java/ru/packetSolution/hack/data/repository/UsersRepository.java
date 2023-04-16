package ru.packetSolution.hack.data.repository;

import java.util.List;

import retrofit2.Call;
import ru.packetSolution.hack.data.api.products.ProductsApiService;
import ru.packetSolution.hack.data.api.users.UsersApiService;
import ru.packetSolution.hack.domain.model.Product;
import ru.packetSolution.hack.domain.model.User;

public class UsersRepository {
    public static Call<List<User>> getUsers(){
        return UsersApiService.getInstance().getUsers();
    }
    public static Call<User> getUser(int id){
        return UsersApiService.getInstance().getUser(id);
    }
    public static Call<Void> deleteProduct(int id){
        return UsersApiService.getInstance().deleteUser(id);
    }
}
