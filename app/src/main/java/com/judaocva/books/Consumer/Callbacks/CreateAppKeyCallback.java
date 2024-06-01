package com.judaocva.books.Consumer.Callbacks;

import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.Login.Dto.CreateOAuthKeyResponse;

public interface CreateAppKeyCallback {
    boolean onSuccess(CreateAppKeyResponse response);

    void onError(Throwable t);
}