package ru.packetSolution.hack.data.api.users;


import ru.packetSolution.hack.data.api.RetrofitService;

public class UsersApiService {
    private static UsersApi usersApi;

    private static UsersApi create(){
        return RetrofitService.getInstance().create(UsersApi.class);
    }

    public static UsersApi getInstance(){
        if (usersApi == null) usersApi = create();
        return usersApi;
    }
}
