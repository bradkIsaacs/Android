package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

public class ExitApplication extends AppCompatActivity {

    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_application);

        yes = findViewById(R.id.btn_exit_application_yes);
        no = findViewById(R.id.btn_exit_application_no);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        yes.setOnClickListener(v -> {
            this.finishAffinity();
        });

        no.setOnClickListener(v -> {
            finish();
        });
    }
}