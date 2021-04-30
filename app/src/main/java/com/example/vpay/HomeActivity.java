package com.example.vpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn1 = findViewById(R.id.btnaddcard);
        Button btn2 = findViewById(R.id.btnviewcard);

        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(this, com.example.vpay.CardForm.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewCard.class);
            startActivity(intent);
        });
    }
}