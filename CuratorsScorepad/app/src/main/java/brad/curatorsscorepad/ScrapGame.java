package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

public class ScrapGame extends AppCompatActivity {

    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap_game);

        yes = findViewById(R.id.btn_scrap_game_yes);
        no = findViewById(R.id.btn_scrap_game_no);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.4));

        yes.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        no.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
    }
}