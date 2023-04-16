package ru.packetSolution.hack.data.api.users;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.packetSolution.hack.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {


    // https://base.com/user_via_email?email=hgfhjhg&p=fhnjfgh
    @POST("/user_email")
    Call<Void> insertUser(@Query("email") String email, @Query("password") String password);
    @GET("/user")
    Call<List<User>> getUsers();

    @GET("user/{id}")
    Call<User> getUser(
            @Path("id")
            long id
    );

    @DELETE("user/{id}")
    Call<Void> deleteUser(
            @Path("id")
            long id
    );


}
