package com.judaocva.books.Consumer.Callbacks;

import com.google.gson.JsonObject;

public interface GetAllBooksCallback {
    void onSuccess(JsonObject response);
    void onError(Throwable t);
}
