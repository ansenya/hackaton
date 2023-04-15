package ru.packetSolution.hack.data.api.users;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.packetSolution.hack.model.User;

public interface UsersApi {

    @GET("/user")
    Call<List<User>> getUsers();
}
