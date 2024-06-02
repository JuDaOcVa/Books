package com.judaocva.books.Main;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.judaocva.books.Consumer.Callbacks.GetAllBooksCallback;
import com.judaocva.books.Consumer.RestConsumer;
import com.judaocva.books.Main.Dto.Book;
import com.judaocva.books.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainController {
    private Context context;

    public MainController(Context context) {
        this.context = context;
    }

    public CompletableFuture<List<Book>> getAllBooks() {
        CompletableFuture<List<Book>> future = new CompletableFuture<>();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("session_data", Context.MODE_PRIVATE);
            String o_u = sharedPreferences.getString("o_u", "");
            String sesskey = sharedPreferences.getString("sesskey", "");
            RestConsumer.getAllBooks(context.getString(R.string.app_version), context.getString(R.string.getAllBooks_endpoint), o_u, o_u, sesskey, context, new GetAllBooksCallback() {
                @Override
                public void onSuccess(JsonObject bookResponses) {
                    if (bookResponses == null) {
                        Log.e("MainController getAllBooks", "bookResponses is null");
                        future.completeExceptionally(new NullPointerException("bookResponses is null"));
                        return;
                    }
                    // Parse the response and return the list of books
                    try {
                        List<Book> books = new ArrayList<>();
                        JsonObject jsonObjectAllBooks = bookResponses.getAsJsonObject("allBooks");
                        JsonArray jsonArray = jsonObjectAllBooks.getAsJsonArray("books");
                        for (JsonElement jsonObjectBook : jsonArray) {
                            JsonObject jsonObjectCoverImg = jsonObjectBook.getAsJsonObject().getAsJsonObject("ownerPrefs");
                            Book book = new Book();
                            book.setB_c(jsonObjectBook.getAsJsonObject().get("b_c").getAsString());
                            book.setoCoverImg(context.getString(R.string.timetonic_url).concat(jsonObjectCoverImg.get("oCoverImg").getAsString()));
                            books.add(book);
                        }
                        future.complete(books);
                    } catch (JsonSyntaxException e) {
                        Log.e("MainController getAllBooks", "Error parsing bookResponses", e);
                        future.completeExceptionally(e);
                    }
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