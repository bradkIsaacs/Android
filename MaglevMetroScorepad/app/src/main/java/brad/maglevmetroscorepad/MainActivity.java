package brad.maglevmetroscorepad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button scoreGame, viewHistory, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreGame = findViewById(R.id.btn_ScoreGame);
        viewHistory = findViewById(R.id.btn_GameHistory);
        exit = findViewById(R.id.btn_exit);

        scoreGame.setOnClickListener(v -> {
            startActivity(new Intent(this, Players.class));
        });

        viewHistory.setOnClickListener(v -> {
            startActivity(new Intent(this, GameHistory.class));
        });

        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }

    @Override
    public void onBackPressed() { }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int id= android.os.Process.myPid();
        android.os.Process.killProcess(id);
    }
}