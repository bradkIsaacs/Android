package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Wings extends AppCompatActivity {

    GlobalClass Globe;
    TextView p1, p2, p3, p4;
    EditText p1Score, p2Score, p3Score, p4Score;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wings);

        Globe = (GlobalClass) getApplicationContext();
        p1 = findViewById(R.id.tv_player1Wing);
        p2 = findViewById(R.id.tv_player2Wing);
        p3 = findViewById(R.id.tv_player3Wing);
        p4 = findViewById(R.id.tv_player4Wing);
        p1Score = findViewById(R.id.et_player1Wing);
        p2Score = findViewById(R.id.et_player2Wing);
        p3Score = findViewById(R.id.et_player3Wing);
        p4Score = findViewById(R.id.et_player4Wing);
        submit = findViewById(R.id.btn_wing_submit);

        p1.setText(Globe.getP1());
        p2.setText(Globe.getP2());
        p3.setText(Globe.getP3());
        p4.setText(Globe.getP4());

        submit.setOnClickListener(v ->{
            if(p1Score.getText().toString().matches("") || p2Score.getText().toString().matches("") || p3Score.getText().toString().matches("") || p4Score.getText().toString().matches("") ){
                Toast.makeText(this,"One or more scores is missing.\nIf no player please enter 0", Toast.LENGTH_LONG).show();
            }
            else {
                Globe.setP1Score(Integer.parseInt(p1Score.getText().toString()));
                Globe.setP2Score(Integer.parseInt(p2Score.getText().toString()));
                Globe.setP3Score(Integer.parseInt(p3Score.getText().toString()));
                Globe.setP4Score(Integer.parseInt(p4Score.getText().toString()));
                startActivity(new Intent(this, Objects.class));
            }
        });
    }
}