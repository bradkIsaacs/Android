package com.example.bradley.multipage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void twoPlayerGame(View v){
        startActivity(new Intent(this, twoPlayer.class));
    }
    public void threePlayerGame(View v){

    }
    public void fourPlayerGame(View v){

    }
    public void history(View v){

    }
}
