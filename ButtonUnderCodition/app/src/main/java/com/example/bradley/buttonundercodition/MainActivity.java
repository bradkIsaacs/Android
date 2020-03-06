package com.example.bradley.buttonundercodition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button b;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.editText);
        b = (Button)findViewById(R.id.button);
        display = (TextView)findViewById(R.id.textView);
    }

    public void visable(View view){
        if(input.getText().toString().equals("")){
            Toast.makeText(this,"One of the input fields is empty", Toast.LENGTH_LONG).show();
            display.setText("");
        } else {
            b.setClickable(true);
            display.setText("Success");
        }
    }
}
