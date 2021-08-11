package brad.curatorsscorepad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    TextView display;
    String LIST = "list";
    String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        
        display = findViewById(R.id.tv_history);
        display.setText("");
        load();
    }

    public void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String[] res = sharedPreferences.getString(LIST, "").split(",", 0);
        for(int i=0; i<res.length; i++){
            display.append(res[i]+"\n");
        }
    }
}