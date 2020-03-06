package com.example.bradley.printarraylist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView display;
    ArrayList<String> test = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
    String currentDateandDay;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView)findViewById(R.id.textView);
        input = (EditText)findViewById(R.id.editText);
        currentDateandDay = sdf.format(new Date());
    }

    public void displayList(View v){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < test.size(); i++){
            sb.append(test.get(i)).append("\n");
        }
        display.setText(sb.toString());
    }

    public void saveList(View v){
        load();
        //Build Array
        test.add(currentDateandDay);
        test.add(input.getText().toString());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<test.size(); i++){
            sb.append(test.get(i)).append(",");
        }
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putString("Array", sb.toString());
        edit.commit();
    }

    public void loadList(View v){
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        String items = settings.getString("Array", "");
        String[] arr = items.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            arrayList.add(arr[i]);
        }
        test = arrayList;
    }

    public void load(){
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        String items = settings.getString("Array", "");
        String[] arr = items.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            arrayList.add(arr[i]);
        }
        test = arrayList;
    }
}