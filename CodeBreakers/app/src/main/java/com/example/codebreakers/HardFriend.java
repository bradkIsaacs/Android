package com.example.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;
import java.util.List;

public class HardFriend extends AppCompatActivity {

    String[] code = new String[6];
    ScrollChoice d1, d2, d3, d4, d5, d6;
    List<String> digits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_friend);
        initViews();
        loadList();
        d1.addItems(digits, 0);
        d2.addItems(digits, 0);
        d3.addItems(digits, 0);
        d4.addItems(digits, 0);
        d5.addItems(digits, 0);
        d6.addItems(digits, 0);
        d1.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[0] = name;
            }
        });
        d2.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[1] = name;
            }
        });
        d3.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[2] = name;
            }
        });
        d4.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[3] = name;
            }
        });
        d5.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[4] = name;
            }
        });
        d6.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                code[5] = name;
            }
        });
    }

    private void initViews() {
        d1 = findViewById(R.id.hard_friend_digit_1);
        d2 = findViewById(R.id.hard_friend_digit_2);
        d3 = findViewById(R.id.hard_friend_digit_3);
        d4 = findViewById(R.id.hard_friend_digit_4);
        d5 = findViewById(R.id.hard_friend_digit_5);
        d6 = findViewById(R.id.hard_friend_digit_6);
    }

    private void loadList() {
        digits.add("0");
        digits.add("1");
        digits.add("2");
        digits.add("3");
        digits.add("4");
        digits.add("5");
        digits.add("6");
        digits.add("7");
        digits.add("8");
        digits.add("9");
    }

    public void hardSetCode(View view) {
        Intent intent = new Intent(this, Hard.class);
        intent.putExtra("code", code);
        intent.putExtra("boolean", true);
        startActivity(intent);
    }
}
