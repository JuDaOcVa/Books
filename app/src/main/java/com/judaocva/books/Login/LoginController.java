package com.judaocva.books.Login;

import android.content.Context;

import com.judaocva.books.Consumer.RestConsumer;
import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.R;
import com.judaocva.books.Consumer.Callbacks.CreateAppKeyCallback;

import java.util.concurrent.CompletableFuture;

public class LoginController {
    private Context context;

    public LoginController(Context context) {
        this.context = context;
    }

    public CompletableFuture<Boolean> validateCredentials() {
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        try {
            RestConsumer.CreateAppKey(context.getString(R.string.app_version), context.getString(R.string.createAppKey_endpoint), context.getString(R.string.app_name), context, new CreateAppKeyCallback() {
                @Override
                public boolean onSuccess(CreateAppKeyResponse response) {
                    System.out.println("validating credentials=====> " + response.toString());
                    return future.complete(response.getStatus().equals("ok"));
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