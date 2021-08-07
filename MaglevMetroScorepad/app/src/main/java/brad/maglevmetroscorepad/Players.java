package brad.maglevmetroscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {
    EditText p1, p2, p3, p4;
    Button submit;
    GlobalClass Globe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        p1 = findViewById(R.id.et_Player1);
        p2 = findViewById(R.id.et_Player2);
        p3 = findViewById(R.id.et_Player3);
        p4 = findViewById(R.id.et_Player4);
        submit = findViewById(R.id.btn_SubmitNames);
        Globe = (GlobalClass) getApplicationContext();

        submit.setOnClickListener(v ->{
            Globe.setP1Name(p1.getText().toString());
            Globe.setP2Name(p2.getText().toString());
            Globe.setP3Name(p3.getText().toString());
            Globe.setP4Name(p4.getText().toString());
            if(Globe.getP1Name().isEmpty() && Globe.getP2Name().isEmpty() && Globe.getP3Name().isEmpty() && Globe.getP4Name().isEmpty()){
                Toast.makeText(this,"Maglev Metro requires at least 1 player",Toast.LENGTH_LONG).show();
            } else {
                startActivity(new Intent(this, ProfessionalScore.class));
            }
        });
    }

    @Override
    public void onBackPressed() { }
}