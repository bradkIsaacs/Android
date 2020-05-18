package com.example.codebreakers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.webianks.library.scroll_choice.ScrollChoice;
import java.util.ArrayList;
import java.util.List;

public class Easy extends AppCompatActivity {

    List<String> digits = new ArrayList<>();
    ScrollChoice d1, d2, d3, d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        initViews();
        loadList();
        d1.addItems(digits, 0);
        d2.addItems(digits, 0);
        d3.addItems(digits, 0);
        d4.addItems(digits, 0);
        /*sc.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                //tv.setText(name);
            }
        });*/
    }

    private void loadList() {
        digits.add("x");
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

    private void initViews() {
        d1 = findViewById(R.id.easy_digit_1);
        d2 = findViewById(R.id.easy_digit_2);
        d3 = findViewById(R.id.easy_digit_3);
        d4 = findViewById(R.id.easy_digit_4);
    }

    public void submitGuess(View view) {
    }
}
