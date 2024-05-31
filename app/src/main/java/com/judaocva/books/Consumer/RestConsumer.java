package com.judaocva.books.Consumer;

import android.content.Context;
import android.util.Log;

import com.judaocva.books.Consumer.Callbacks.CreateAppKeyCallback;
import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.Miscellaneous.ApiService;
import com.judaocva.books.Miscellaneous.GeneralMethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestConsumer {

    private static final String BASE_URL = "https://timetonic.com/live/";
    private static Retrofit retrofit = null;

    public static void CreateAppKey(String version, String req, String appname, Context context, CreateAppKeyCallback callback) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiService apiService = retrofit.create(ApiService.class);
        Call<CreateAppKeyResponse> call = apiService.createAppKey(version, req, appname);

        // Show loading dialog
        GeneralMethods.showLoadingDialog(context);

        // async call to the API endpoint to create an app key
        call.enqueue(new Callback<CreateAppKeyResponse>() {
            @Override
            public void onResponse(Call<CreateAppKeyResponse> call, Response<CreateAppKeyResponse> response) {
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();

                if (response.isSuccessful()) {
                    System.out.println("Response: " + response.body().toString());
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<CreateAppKeyResponse> call, Throwable t) {
                // Dismiss loading dialog
                Log.e("RestConsumer", "Error: " + t.getMessage());
                GeneralMethods.dismissLoadingDialog();
            }
        });
    }
}