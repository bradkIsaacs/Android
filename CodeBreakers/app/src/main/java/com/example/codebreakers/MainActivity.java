package com.example.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int difficulty = 0; //easy=1, medium=2, hard=3
    Button easy, medium, hard;
    TextView guesses, digits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easy = findViewById(R.id.btn_main_easy);
        medium = findViewById(R.id.btn_main_medium);
        hard = findViewById(R.id.btn_main_hard);
        guesses = findViewById(R.id.tv_main_guesses);
        digits = findViewById(R.id.tv_main_digits);
    }

    public void playVsCPU(View view) {
        if(difficulty==0){
            Toast.makeText(getApplicationContext(),"Please select a level of difficulty",Toast.LENGTH_LONG).show();
        }
        else if(difficulty==1){
            startActivity(new Intent(this, Easy.class));
        }
        else if(difficulty==2){
            startActivity(new Intent(this, Medium.class));
        }
    }

    public void playVsFriend(View view) {
        if(difficulty==0){
            Toast.makeText(getApplicationContext(),"Please select a level of difficulty",Toast.LENGTH_LONG).show();
        }
    }

    public void diffEasy(View view) {
        difficulty = 1;
        easy.setVisibility(View.INVISIBLE);
        easy.setEnabled(false);
        medium.setVisibility(View.VISIBLE);
        medium.setEnabled(true);
        hard.setVisibility(View.VISIBLE);
        hard.setEnabled(true);
        guesses.setText("12 guesses");
        digits.setText("4 digit codes");
    }

    public void diffMedium(View view) {
        difficulty = 2;
        easy.setVisibility(View.VISIBLE);
        easy.setEnabled(true);
        medium.setVisibility(View.INVISIBLE);
        medium.setEnabled(false);
        hard.setVisibility(View.VISIBLE);
        hard.setEnabled(true);
        guesses.setText("10 guesses");
        digits.setText("5 digit codes");
    }

    public void diffHard(View view) {
        difficulty = 3;
        easy.setVisibility(View.VISIBLE);
        easy.setEnabled(true);
        medium.setVisibility(View.VISIBLE);
        medium.setEnabled(true);
        hard.setVisibility(View.INVISIBLE);
        hard.setEnabled(false);
        guesses.setText("8 guesses");
        digits.setText("6 digit codes");
    }
}
