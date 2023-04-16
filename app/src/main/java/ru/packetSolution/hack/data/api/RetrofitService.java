package ru.packetSolution.hack.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitService {

    // https:// google.com / path ? search = asdaddsa

    private static final String BASE_URL ="";//todo write URL
    private static Retrofit retrofit;

    private static Retrofit create(){
        return new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static Retrofit getInstance(){
        if (retrofit == null) retrofit = create();
        return retrofit;
    }
}
