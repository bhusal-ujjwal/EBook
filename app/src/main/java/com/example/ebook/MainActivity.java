package com.example.ebook;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername, etPassword;
    Button btnLogin;
    String usernameLogin, passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        usernameLogin = etUsername.getText().toString();
        passwordLogin = etPassword.getText().toString();

        if (usernameLogin.equals("ujjwal") && passwordLogin.equals("ujjwal")){
            etUsername.getText().clear();
            etPassword.getText().clear();
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        } else {
            etUsername.setError("Please enter valid username");
            etPassword.setError("Please enter valid password");
        }
    }
}
