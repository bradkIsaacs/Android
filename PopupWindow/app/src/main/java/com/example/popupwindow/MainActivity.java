package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        window = findViewById(R.id.btn_popup);

        window.setOnClickListener(v -> {
            startActivity(new Intent(this, PopupWindow.class));
        });
    }
}