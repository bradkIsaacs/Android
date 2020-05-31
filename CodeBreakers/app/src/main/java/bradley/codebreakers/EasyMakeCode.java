package bradley.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;

public class EasyMakeCode extends AppCompatActivity {

    ScrollChoice d1, d2, d3, d4;
    String[] code = new String[4];
    ArrayList digits = new ArrayList<String>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_make_code);
        initViews();
        createDigits();
        d1.addItems(digits,0);
        d2.addItems(digits,0);
        d3.addItems(digits,0);
        d4.addItems(digits,0);
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
    }

    private void createDigits() {
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
        d1 = findViewById(R.id.sc_easyMakeCode_d1);
        d2 = findViewById(R.id.sc_easyMakeCode_d2);
        d3 = findViewById(R.id.sc_easyMakeCode_d3);
        d4 = findViewById(R.id.sc_easyMakeCode_d4);
    }

    public void easySubmitCode(View view) {
        intent = new Intent(this, EasyVsCPU.class);
        intent.putExtra("secret", code);
        startActivity(intent);
    }

    public void mediumSubmitCode(View view) {
        intent = new Intent(this, MediumVsCPU.class);
        intent.putExtra("secret", code);
        startActivity(intent);
    }
}
