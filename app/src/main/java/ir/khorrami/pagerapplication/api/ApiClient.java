package ir.khorrami.pagerapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private final static String BASE_URL="https://api.stackexchange.com/2.2/";
    private static ApiClient instance;
    private Retrofit retrofit;

    private ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance()
    {
        if(instance == null)
            instance = new ApiClient();

        return instance;
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }

}
