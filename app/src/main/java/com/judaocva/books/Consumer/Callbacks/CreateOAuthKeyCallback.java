package com.judaocva.books.Consumer.Callbacks;

import com.judaocva.books.Login.Dto.CreateOAuthKeyResponse;

public interface CreateOAuthKeyCallback {
    boolean onSuccess(CreateOAuthKeyResponse response);
    void onError(Throwable t);
}
