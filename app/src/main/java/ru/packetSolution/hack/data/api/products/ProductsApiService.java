package ru.packetSolution.hack.data.api.products;


import ru.packetSolution.hack.data.api.RetrofitService;

public class ProductsApiService {
    private static ProductsApi productsApi;

    private static ProductsApi create(){
        return RetrofitService.getInstance().create(ProductsApi.class);
    }

    public static ProductsApi getInstance(){
        if (productsApi == null) productsApi = create();
        return productsApi;
    }
}
