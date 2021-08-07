package brad.maglevmetroscorepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class GameHistory extends AppCompatActivity {

    TextView display;

    String LIST = "list";
    String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_history);

        display = findViewById(R.id.tv_gameHistory);

        load();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_history: clearGameHistory();
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearGameHistory() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        sp.edit().clear().commit();
        display.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_history, menu);
        return true;
    }

    public void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String[] res = sharedPreferences.getString(LIST, "").split(",", 0);
        for(int i=0; i<res.length; i++){
            display.append(res[i]+"\n");
        }
    }
}