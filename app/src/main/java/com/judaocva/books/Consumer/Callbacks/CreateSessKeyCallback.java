package com.judaocva.books.Consumer.Callbacks;

import com.judaocva.books.Login.Dto.CreateSessKeyResponse;

public interface CreateSessKeyCallback {
    boolean onSuccess(CreateSessKeyResponse response);
    void onError(Throwable t);
}
