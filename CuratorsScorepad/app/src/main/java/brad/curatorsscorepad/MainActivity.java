package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button score, history;
    Switch advanced;
    GlobalClass Globe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.btn_score_game);
        history = findViewById(R.id.btn_history);
        advanced = findViewById(R.id.swi_advanced);
        Globe = (GlobalClass) getApplicationContext();

        score.setOnClickListener(v -> {
            if(advanced.isChecked()){Globe.setAdvanced(true);}
            else{Globe.setAdvanced(false);}
            startActivity(new Intent(this, Players.class));
            finish();
        });

        history.setOnClickListener(v ->{
            startActivity(new Intent(this,History.class));
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ExitApplication.class));
    }
}