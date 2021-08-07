package brad.maglevmetroscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ShowScores extends AppCompatActivity {

    GlobalClass Globe;
    TextView p1, p2, p3, p4;
    EditText p1Score, p2Score, p3Score, p4Score;
    Button submit;

    String game;
    String LIST = "list";
    String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores);

        Globe = (GlobalClass) getApplicationContext();
        p1 = findViewById(R.id.tv_player1Final);
        p2 = findViewById(R.id.tv_player2Final);
        p3 = findViewById(R.id.tv_player3Final);
        p4 = findViewById(R.id.tv_player4Final);
        p1Score = findViewById(R.id.et_player1Final);
        p2Score = findViewById(R.id.et_player2Final);
        p3Score = findViewById(R.id.et_player3Final);
        p4Score = findViewById(R.id.et_player4Final);
        submit = findViewById(R.id.btn_returnHome);

        p1.setText(Globe.getP1Name());
        p2.setText(Globe.getP2Name());
        p3.setText(Globe.getP3Name());
        p4.setText(Globe.getP4Name());

        p1Score.setText(""+Globe.getP1Score());
        p2Score.setText(""+Globe.getP2Score());
        p3Score.setText(""+Globe.getP3Score());
        p4Score.setText(""+Globe.getP4Score());

        submit.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            game = sharedPreferences.getString(LIST, "");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Date date = new Date();
            game += formatter.format(date)+",";
            if(!Globe.getP1Name().isEmpty()) { game += Globe.getP1Name() + ": " + Globe.getP1Score() + ","; }
            if(!Globe.getP2Name().isEmpty()) { game += Globe.getP2Name() + ": " + Globe.getP2Score() + ","; }
            if(!Globe.getP3Name().isEmpty()) { game += Globe.getP3Name() + ": " + Globe.getP3Score() + ","; }
            if(!Globe.getP4Name().isEmpty()) { game += Globe.getP4Name() + ": " + Globe.getP4Score() + ","; }
            game += "-------------------------------------------------------------------------------,";
            editor.putString(LIST, game).commit();
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    @Override
    public void onBackPressed() { }
}