package com.example.codebreakers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Easy extends AppCompatActivity {

    int c_place=0, i_place=0, guesses=0;
    String[] code = new String[4];
    String[] save_code = new String[4];
    String[] guess = new String[4];
    String[] save_guess = new String[4];
    List<String> digits = new ArrayList<>();
    List<Previous> pList = new ArrayList<>();
    ListView myList;
    ScrollChoice d1, d2, d3, d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        createCode();
        initViews();
        loadList();
        d1.addItems(digits, 0);
        d2.addItems(digits, 0);
        d3.addItems(digits, 0);
        d4.addItems(digits, 0);
        d1.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[0] = name;
            }
        });
        d2.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[1] = name;
            }
        });
        d3.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[2] = name;
            }
        });
        d4.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[3] = name;
            }
        });
    }

    private void createCode() {
        Random rand = new Random();
        for (int i=0; i<4; i++){
            code[i] = ""+rand.nextInt(9);
        }
        save_code = code.clone();
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
        myList = findViewById(R.id.easy_list_view);
    }

    public void submitGuess(View view) {
        guesses++;
        save_guess = guess.clone();
        cPlace(code, guess);
        iPlace(code, guess);
        Previous x = new Previous(save_guess, c_place, i_place);
        pList.add(x);
        PreviousAdapter adapter = new PreviousAdapter(this, R.layout.my_array_adaptor, pList);
        myList.setAdapter(adapter);
        if(c_place == 4){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", true);
            i.putExtra("c", save_code);
            startActivity(i);
        }
        else if(guesses == 12){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", false);
            i.putExtra("c", save_code);
            startActivity(i);
        }
        resetPlaces();
        resetCode();
    }

    private void resetCode() {
        code = save_code.clone();
        guess = save_guess.clone();
    }

    private void resetPlaces() {
        i_place=0;
        c_place=0;
    }

    private void iPlace(String[] code, String[] guess){
        for(int i=0; i<guess.length; i++){
            for(int j=0; j<code.length; j++){
                if(code[j].equals(guess[i])){
                    guess[i] = "13";
                    code[j] = "12";
                    i_place++;
                }
            }
        }
    }

    private void cPlace(String[] code, String[] guess) {
        for(int i=0; i<code.length; i++){
            if(code[i].equals(guess[i])){
                guess[i] = "11";
                code[i] = "10";
                c_place++;
            }
        }
    }
}
