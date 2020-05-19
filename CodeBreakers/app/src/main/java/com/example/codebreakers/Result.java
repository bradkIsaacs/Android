package com.example.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView text, guesses, code;
    boolean wl;
    int num;
    String[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        text = findViewById(R.id.result_text);
        guesses = findViewById(R.id.result_guesses);
        code = findViewById(R.id.result_code);
        Intent intent = getIntent();
        wl = intent.getBooleanExtra("b",true);
        num = intent.getIntExtra("g", 0);
        array = intent.getStringArrayExtra("c");
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<array.length; i++){
            temp.append(array[i]+" ");
        }
        if(wl){
            text.setText("You Have Broken The Code");
            guesses.setText("It Took you "+num+" guesses");
            code.setText(temp);
        }
        else{
            text.setText("You Have Failed To Break The Code");
            guesses.setText("---------------------");
            code.setText(temp);
        }
    }
}
