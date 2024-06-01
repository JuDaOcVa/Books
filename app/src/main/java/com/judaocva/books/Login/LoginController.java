package com.judaocva.books.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.judaocva.books.Consumer.Callbacks.CreateOAuthKeyCallback;
import com.judaocva.books.Consumer.Callbacks.CreateSessKeyCallback;
import com.judaocva.books.Consumer.RestConsumer;
import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.Login.Dto.CreateOAuthKeyResponse;
import com.judaocva.books.Login.Dto.CreateSessKeyResponse;
import com.judaocva.books.Login.Dto.LoginDto;
import com.judaocva.books.R;
import com.judaocva.books.Consumer.Callbacks.CreateAppKeyCallback;

import java.util.concurrent.CompletableFuture;

public class LoginController {
    private Context context;
    private LoginDto user;

    public LoginController(Context context, LoginDto user) {
        this.context = context;
        this.user = user;
    }

    public CompletableFuture<Boolean> validateCredentials() {
        CompletableFuture<Boolean> future = new CompletableFuture<>();
        try {
            createAppKeyResponse().whenComplete((responseCreateAppKey, ex) -> {
                if (ex != null) {
                    future.completeExceptionally(ex);
                } else {
                    createOAuthKeyResponse(user.getEmail(), user.getPassword(), responseCreateAppKey.getAppkey()).whenComplete((responseCreateOAuthKey, ex2) -> {
                        if (ex2 != null) {
                            future.completeExceptionally(ex2);
                        } else {
                            createSessKeyResponse(responseCreateOAuthKey.getO_u(), responseCreateOAuthKey.getO_u(), responseCreateOAuthKey.getOauthkey()).whenComplete((responseCreateSessKey, ex3) -> {
                                if (ex3 != null) {
                                    future.completeExceptionally(ex3);
                                } else {
                                    if (responseCreateSessKey != null) {
                                        SharedPreferences sharedPreferences = context.getSharedPreferences("session_data", Context.MODE_PRIVATE);
                                        sharedPreferences.edit().putString("sesskey", responseCreateSessKey.getSesskey()).apply();
                                        future.complete(responseCreateSessKey.getStatus().equals("ok"));
                                    }
                                }
                            });
                        }
                    });
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    public CompletableFuture<CreateAppKeyResponse> createAppKeyResponse() {
        CompletableFuture<CreateAppKeyResponse> future = new CompletableFuture<>();
        try {
            RestConsumer.createAppKey(context.getString(R.string.app_version), context.getString(R.string.createAppKey_endpoint), context.getString(R.string.app_name), context, new CreateAppKeyCallback() {
                @Override
                public boolean onSuccess(CreateAppKeyResponse responseCreateAppKey) {
                    Log.i("CreateAppKeyResponse", responseCreateAppKey.toString());
                    return future.complete(responseCreateAppKey);
                }

                @Override
                public void onError(Throwable t) {
                    future.completeExceptionally(t);
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    public CompletableFuture<CreateOAuthKeyResponse> createOAuthKeyResponse(String login, String password, String appkey) {
        CompletableFuture<CreateOAuthKeyResponse> future = new CompletableFuture<>();
        try {
            RestConsumer.createOAuthKey(context.getString(R.string.app_version), context.getString(R.string.createOauthkey_endpoint), login, password, appkey, context, new CreateOAuthKeyCallback() {
                @Override
                public boolean onSuccess(CreateOAuthKeyResponse response) {
                    Log.i("CreateAppKeyResponse", response.toString());
                    return future.complete(response);
                }

                @Override
                public void onError(Throwable t) {
                    future.completeExceptionally(t);
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    public CompletableFuture<CreateSessKeyResponse> createSessKeyResponse(String o_u, String u_c, String oauthkey) {
        CompletableFuture<CreateSessKeyResponse> future = new CompletableFuture<>();
        try {
            RestConsumer.createSessKey(context.getString(R.string.app_version), context.getString(R.string.createSesskey_endpoint), o_u, u_c, oauthkey, context, new CreateSessKeyCallback() {
                @Override
                public boolean onSuccess(CreateSessKeyResponse response) {
                    Log.i("CreateSessKeyResponse", response.toString());
                    return future.complete(response);
                }

                @Override
                public void onError(Throwable t) {
                    future.completeExceptionally(t);
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

}