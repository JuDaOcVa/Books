package com.judaocva.books.Consumer;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.judaocva.books.Consumer.Callbacks.CreateAppKeyCallback;
import com.judaocva.books.Consumer.Callbacks.CreateOAuthKeyCallback;
import com.judaocva.books.Consumer.Callbacks.CreateSessKeyCallback;
import com.judaocva.books.Consumer.Callbacks.GetAllBooksCallback;
import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.Login.Dto.CreateOAuthKeyResponse;
import com.judaocva.books.Login.Dto.CreateSessKeyResponse;
import com.judaocva.books.Login.Service.ApiServiceLogin;
import com.judaocva.books.Main.Service.ApiServiceMain;
import com.judaocva.books.Miscellaneous.GeneralMethods;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestConsumer {

    private static final String BASE_URL = "https://timetonic.com/live/";
    private static Retrofit retrofit = null;

    public static void createAppKey(String version, String req, String appname, Context context, CreateAppKeyCallback callback) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiServiceLogin apiService = retrofit.create(ApiServiceLogin.class);
        Call<CreateAppKeyResponse> call = apiService.createAppKey(version, req, appname);

        // Show loading dialog
        GeneralMethods.showLoadingDialog(context);

        // async call to the API endpoint to create an app key
        call.enqueue(new Callback<CreateAppKeyResponse>() {
            @Override
            public void onResponse(@NonNull Call<CreateAppKeyResponse> call, @NonNull Response<CreateAppKeyResponse> response) {
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();

                if (response.isSuccessful()) {
                    Log.i("Response createAppKey: ", response.body().toString());
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CreateAppKeyResponse> call, @NonNull Throwable t) {
                // Dismiss loading dialog
                Log.e("RestConsumer createAppKey", "Error: " + t.getMessage());
                callback.onError(t);
                GeneralMethods.dismissLoadingDialog();
            }
        });
    }

    public static void createOAuthKey(String version, String req, String login, String password, String appkey, Context context, CreateOAuthKeyCallback callback) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiServiceLogin apiService = retrofit.create(ApiServiceLogin.class);
        Call<CreateOAuthKeyResponse> call = apiService.createOauthKey(version, req, login, password, appkey);

        // Show loading dialog
        GeneralMethods.showLoadingDialog(context);

        // async call to the API endpoint to create an OAuth key
        call.enqueue(new Callback<CreateOAuthKeyResponse>() {
            @Override
            public void onResponse(@NonNull Call<CreateOAuthKeyResponse> call, @NonNull Response<CreateOAuthKeyResponse> response) {
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();

                if (response.isSuccessful()) {
                    Log.i("Response createOAuthKey: ", response.body().toString());
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CreateOAuthKeyResponse> call, @NonNull Throwable t) {
                // Dismiss loading dialog
                Log.e("RestConsumer createOAuthKey", "Error: " + t.getMessage());
                callback.onError(t);
                GeneralMethods.dismissLoadingDialog();
            }
        });
    }

    public static void createSessKey(String version, String req, String o_u, String u_c, String oauthkey, Context context, CreateSessKeyCallback callback) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiServiceLogin apiService = retrofit.create(ApiServiceLogin.class);
        Call<CreateSessKeyResponse> call = apiService.createSessKey(version, req, o_u, u_c, oauthkey);

        // Show loading dialog
        GeneralMethods.showLoadingDialog(context);

        // async call to the API endpoint to create a session key
        call.enqueue(new Callback<CreateSessKeyResponse>() {
            @Override
            public void onResponse(@NonNull Call<CreateSessKeyResponse> call, @NonNull Response<CreateSessKeyResponse> response) {
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();

                if (response.isSuccessful()) {
                    Log.i("Response createSessKey: ", response.body().toString());
                    callback.onSuccess(response.body());

                }
            }

            @Override
            public void onFailure(@NonNull Call<CreateSessKeyResponse> call, @NonNull Throwable t) {
                // Dismiss loading dialog
                Log.e("RestConsumer createSessKey", "Error: " + t.getMessage());
                callback.onError(t);
                GeneralMethods.dismissLoadingDialog();
            }
        });
    }

    public static void getAllBooks(String version, String req, String u_c, String o_u, String sesskey, Context context, GetAllBooksCallback callback) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiServiceMain apiService = retrofit.create(ApiServiceMain.class);
        Call<JsonObject> call = apiService.getAllBooks(version, req, u_c, o_u, sesskey);

        // Show loading dialog
        GeneralMethods.showLoadingDialog(context);

        // async call to the API endpoint to get all books user authenticated
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();

                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                Log.e("RestConsumer getAllBooks", "Error: " + t.getMessage());
                callback.onError(t);
                // Dismiss loading dialog
                GeneralMethods.dismissLoadingDialog();
            }
        });
    }
}