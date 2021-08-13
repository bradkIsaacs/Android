package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    EditText p1Name, p2Name, p3Name, p4Name;
    Button submitNames;
    GlobalClass Globe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        p1Name = findViewById(R.id.et_player1);
        p2Name = findViewById(R.id.et_player2);
        p3Name = findViewById(R.id.et_player3);
        p4Name = findViewById(R.id.et_player4);
        submitNames = findViewById(R.id.btn_players_submit);
        Globe = (GlobalClass) getApplicationContext();

        submitNames.setOnClickListener(v -> {
            if(p1Name.getText().toString().isEmpty() && p2Name.getText().toString().isEmpty() && p3Name.getText().toString().isEmpty() && p4Name.getText().toString().isEmpty()){
                Toast.makeText(this,"Curators requires at least one player",Toast.LENGTH_LONG).show();
            }else{
                Globe.setP1(p1Name.getText().toString());
                Globe.setP2(p2Name.getText().toString());
                Globe.setP3(p3Name.getText().toString());
                Globe.setP4(p4Name.getText().toString());
                startActivity(new Intent(this,Money.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ScrapGame.class));
    }
}