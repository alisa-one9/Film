package com.example.film.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Button;

import com.example.film.R;

public class MainActivity extends AppCompatActivity {
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.btn_accept);

        save.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(this,R.id.fragment);
            navController.navigate(R.id.roomFragment);
        });
    }
}