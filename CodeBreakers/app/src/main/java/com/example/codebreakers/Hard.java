package com.example.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hard extends AppCompatActivity {

    int c_place=0, i_place=0, guesses=0, left=8;
    String[] code = new String[6];
    String[] save_code = new String[6];
    String[] guess = new String[6];
    String[] save_guess = new String[6];
    List<String> digits = new ArrayList<>();
    List<Previous> pList = new ArrayList<>();
    ListView myList;
    TextView remaining;
    ScrollChoice d1, d2, d3, d4, d5, d6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        createCode();
        initViews();
        loadList();
        remaining.setText("Guesses Remaing: "+left);
        d1.addItems(digits, 0);
        d2.addItems(digits, 0);
        d3.addItems(digits, 0);
        d4.addItems(digits, 0);
        d5.addItems(digits, 0);
        d6.addItems(digits, 0);
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
        d5.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[4] = name;
            }
        });
        d6.setOnItemSelectedListener(new ScrollChoice.OnItemSelectedListener() {
            @Override
            public void onItemSelected(ScrollChoice scrollChoice, int position, String name) {
                guess[5] = name;
            }
        });
    }
    private void createCode() {
        Random rand = new Random();
        for (int i=0; i<code.length; i++){
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
        d1 = findViewById(R.id.hard_digit_1);
        d2 = findViewById(R.id.hard_digit_2);
        d3 = findViewById(R.id.hard_digit_3);
        d4 = findViewById(R.id.hard_digit_4);
        d5 = findViewById(R.id.hard_digit_5);
        d6 = findViewById(R.id.hard_digit_6);
        myList = findViewById(R.id.hard_list_view);
        remaining = findViewById(R.id.hard_remaining);
    }

    public void submitGuess(View view) {
        guesses++;
        left--;
        save_guess = guess.clone();
        cPlace(code, guess);
        iPlace(code, guess);
        Previous x = new Previous(save_guess, c_place, i_place);
        pList.add(x);
        PreviousAdapter adapter = new PreviousAdapter(this, R.layout.my_array_adaptor, pList);
        myList.setAdapter(adapter);
        if(c_place == code.length){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", true);
            i.putExtra("c", save_code);
            startActivity(i);
        }
        else if(guesses == 8){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", false);
            i.putExtra("c", save_code);
            startActivity(i);
        }
        resetPlaces();
        resetCode();
        if(left>1){ remaining.setText("Guesses Remaing: "+left); }
        else if(left==1){ remaining.setText("Final Guess"); }
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
