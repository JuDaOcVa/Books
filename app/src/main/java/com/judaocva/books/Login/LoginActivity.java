package com.judaocva.books.Login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.judaocva.books.Login.Dto.LoginDto;
import com.judaocva.books.Miscellaneous.GeneralMethods;
import com.judaocva.books.R;

import java.util.concurrent.CompletableFuture;

public class LoginActivity extends AppCompatActivity {
    EditText email_edt, password_edt;
    Button btnSignIn;
    LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_edt.getText().toString();
                String password = password_edt.getText().toString();

                if (email.isEmpty()) {
                    email_edt.setError(getString(R.string.email_required_msj));
                    email_edt.requestFocus();
                } else if (password.isEmpty()) {
                    password_edt.setError(getString(R.string.password_required_msj));
                    password_edt.requestFocus();
                } else {
                    LoginDto user = new LoginDto(email, password);
                    controller = new LoginController(LoginActivity.this);
                    CompletableFuture<Boolean> future = controller.validateCredentials();
                    future.whenComplete((isValid, ex) -> {
                        if (ex != null) {
                            // Handle error
                            GeneralMethods.showAlert("Error", ex.getMessage(), LoginActivity.this);
                        } else if (!isValid) {
                            // Handle invalid credentials
                            GeneralMethods.showAlert("Error", getString(R.string.incorrect_creedentials_msj), LoginActivity.this);
                        } else {
                            System.out.println("Credentials are valid");
                            // Navigate to main activity
                        }
                    });

                }
            }
        });
    }

    private void init() {
        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);
        btnSignIn = findViewById(R.id.signIn_btn);
    }
}