package com.judaocva.books.Main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.judaocva.books.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MainController controller;
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        controller.getAllBooks().thenAccept(books -> {
            // Update the adapter with the books received from the API
            adapter.updateBooks(books);
            Log.i("MainActivity", "Books getting from API: " + books.toString());
        }).exceptionally(e -> {
            Log.e("MainActivity", "Error getting books", e);
            return null;
        });
    }
}