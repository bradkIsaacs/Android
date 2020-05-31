package bradley.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;
import java.util.Random;

public class MediumVsCPU extends AppCompatActivity {

    int c_place=0, i_place=0, guesses=0, left=10;
    String[] secret = new String[5];
    String[] secretCopy = new String[5];
    String[] guess = new String[5];
    String[] guessCopy = new String[5];
    ArrayList digits = new ArrayList<String>();
    ArrayList hist = new ArrayList<History>();
    TextView remaining;
    ListView lv;
    ScrollChoice d1, d2, d3, d4, d5;
    Intent received;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_vs_cpu);
        received = getIntent();
        createCode();
        initViews();
        createDigitsList();
        d1.addItems(digits,0);
        d2.addItems(digits,0);
        d3.addItems(digits,0);
        d4.addItems(digits,0);
        d5.addItems(digits,0);
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
    }

    private void createDigitsList() {
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
        remaining = findViewById(R.id.tv_mediumVsCPU_remaining);
        lv = findViewById(R.id.lv_mediumVsCPU_list);
        d1 = findViewById(R.id.sc_mediumVsCPU_d1);
        d2 = findViewById(R.id.sc_mediumVsCPU_d2);
        d3 = findViewById(R.id.sc_mediumVsCPU_d3);
        d4 = findViewById(R.id.sc_mediumVsCPU_d4);
        d5 = findViewById(R.id.sc_mediumVsCPU_d5);
    }

    private void createCode() {
        if (received.getStringArrayExtra("secret")!=null){secret = received.getStringArrayExtra("secret");}
        else{
            Random rand = new Random();
            for (int i = 0; i < secret.length; i++) {
                secret[i] = "" + rand.nextInt(9);
            }
        }
        secretCopy = secret.clone();
    }

    public void submitGuess(View view) {
        guesses++;
        left--;
        guessCopy = guess.clone();
        cPlace(secret, guess);
        iPlace(secret, guess);
        History pre = new History(guessCopy, c_place, i_place);
        hist.add(pre);
        HistoryAdaptor adaptor = new HistoryAdaptor(this, R.layout.my_array_adaptor, hist);
        lv.setAdapter(adaptor);
        if(c_place == secret.length){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", true);
            i.putExtra("c", secretCopy);
            startActivity(i);
        }
        else if(guesses == 10){
            Intent i = new Intent(this, Result.class);
            i.putExtra("g", guesses);
            i.putExtra("b", false);
            i.putExtra("c", secretCopy);
            startActivity(i);
        }
        resetAll();
        if(left>1){ remaining.setText("Guesses Remaing: "+left); }
        else if(left==1){ remaining.setText("Final Guess"); }
    }

    private void resetAll() {
        secret = secretCopy.clone();
        guess = guessCopy.clone();
        i_place=0;
        c_place=0;
    }

    private void iPlace(String[] code, String[] guess) {
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (code[j].equals(guess[i])) {
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
