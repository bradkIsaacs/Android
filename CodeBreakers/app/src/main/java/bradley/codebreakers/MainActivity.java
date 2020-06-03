package bradley.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display;
    Button easy, medium, hard;
    int difficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        startService(new Intent(this, MyService.class));
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyService.class));
    }

    private void initViews() {
        display = findViewById(R.id.tv_main_display);
        easy = findViewById(R.id.btn_main_easy);
        medium = findViewById(R.id.btn_main_medium);
        hard = findViewById(R.id.btn_main_hard);
    }

    public void vsCPU(View view) {
        if (difficulty==0){
            Toast.makeText(this,"Please select easy, medium, or hard difficulty first",Toast.LENGTH_SHORT).show();
        }
        else if (difficulty==1){ startActivity(new Intent(this, EasyVsCPU.class)); }
        else if (difficulty==2){ startActivity(new Intent(this, MediumVsCPU.class)); }
        else if (difficulty==3){ startActivity(new Intent(this, HardVsCPU.class)); }
    }

    public void vsFriend(View view) {
        if (difficulty==0){
            Toast.makeText(this,"Please select easy, medium, or hard difficulty first",Toast.LENGTH_SHORT).show();
        }
        else if (difficulty==1){ startActivity(new Intent(this, EasyMakeCode.class)); }
        else if (difficulty==2){ startActivity(new Intent(this, MediumMakeCode.class)); }
        else if (difficulty==3){ startActivity(new Intent(this, HardMakeCode.class)); }
    }

    public void Easy(View view) {
        difficulty = 1;
        display.setText("4 Digit Codes\nMax of 12 Guesses");
        easy.setVisibility(View.INVISIBLE);
        easy.setClickable(false);
        medium.setVisibility(View.VISIBLE);
        medium.setClickable(true);
        hard.setVisibility(View.VISIBLE);
        hard.setClickable(true);
    }

    public void Medium(View view) {
        difficulty = 2;
        display.setText("5 Digit Codes\nMax of 10 Guesses");
        easy.setVisibility(View.VISIBLE);
        easy.setClickable(true);
        medium.setVisibility(View.INVISIBLE);
        medium.setClickable(false);
        hard.setVisibility(View.VISIBLE);
        hard.setClickable(true);
    }

    public void Hard(View view) {
        difficulty = 3;
        display.setText("6 Digit Codes\nMax of 8 Guesses");
        easy.setVisibility(View.VISIBLE);
        easy.setClickable(true);
        medium.setVisibility(View.VISIBLE);
        medium.setClickable(true);
        hard.setVisibility(View.INVISIBLE);
        hard.setClickable(false);
    }
}
