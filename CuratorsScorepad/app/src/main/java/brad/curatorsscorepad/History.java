package brad.curatorsscorepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_clear_history:
                clearShared();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearShared() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        display.setText("");
    }

    public void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String[] res = sharedPreferences.getString(LIST, "").split(",", 0);
        for(int i=0; i<res.length; i++){
            display.append(res[i]+"\n");
        }
    }
}