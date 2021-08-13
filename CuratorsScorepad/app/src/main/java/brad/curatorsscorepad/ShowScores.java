package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowScores extends AppCompatActivity {

    GlobalClass Globe;
    TextView p1, p2, p3, p4;
    Button submit;
    String game;
    String LIST = "list";
    String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores);

        Globe = (GlobalClass) getApplicationContext();
        p1 = findViewById(R.id.tv_player1Score);
        p2 = findViewById(R.id.tv_player2Score);
        p3 = findViewById(R.id.tv_player3Score);
        p4 = findViewById(R.id.tv_player4Score);
        submit = findViewById(R.id.btn_exit);

        p1.setText(Globe.getP1()+": "+Globe.getP1Score());
        p2.setText(Globe.getP2()+": "+Globe.getP2Score());
        p3.setText(Globe.getP3()+": "+Globe.getP3Score());
        p4.setText(Globe.getP4()+": "+Globe.getP4Score());

        submit.setOnClickListener(v ->{
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            game = sharedPreferences.getString(LIST, "");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Date date = new Date();
            game += formatter.format(date)+",";
            if(!Globe.getP1().isEmpty()) { game += Globe.getP1() + ": " + Globe.getP1Score() + ","; }
            if(!Globe.getP2().isEmpty()) { game += Globe.getP2() + ": " + Globe.getP2Score() + ","; }
            if(!Globe.getP3().isEmpty()) { game += Globe.getP3() + ": " + Globe.getP3Score() + ","; }
            if(!Globe.getP4().isEmpty()) { game += Globe.getP4() + ": " + Globe.getP4Score() + ","; }
            game += "-------------------------------------------------------------------------------,";
            editor.putString(LIST, game).commit();
            startActivity(new Intent(this,MainActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ScrapGame.class));
    }
}