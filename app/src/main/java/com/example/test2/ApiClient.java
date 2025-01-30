package com.example.test2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.met.no";
    private static final String USER_AGENT = "Labb_1/1.0";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            // Create an OkHttpClient with an interceptor to add the User-Agent header
            OkHttpClient client = new OkHttpClient.Builder()
                    // Add an interceptor to the OkHttpClient using a lambda expression
                    .addInterceptor(chain -> { // Lambda expression from code completion
                        // Get the original request
                        Request original = chain.request();
                        // Create a new request with the User-Agent header
                        Request request = original.newBuilder()
                                .header("User-Agent", USER_AGENT)
                                .method(original.method(), original.body())
                                .build();
                        // Proceed with the request
                        return chain.proceed(request);
                    })
                    .build();

            // Build the Retrofit instance
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}