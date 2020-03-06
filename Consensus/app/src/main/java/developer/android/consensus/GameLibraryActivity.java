package developer.android.consensus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameLibraryActivity extends AppCompatActivity {

    private ArrayList<String> gameLibrary;
    private ArrayAdapter<String> adapter;
    EditText gameName;
    Button addGame;
    ListView gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_library);
        gameLibrary = new ArrayList();
        setIDs();
        listeners();
        loadLibrary();
    }

    private void loadLibrary() {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_PAGE), MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(getString(R.string.GAME_LIBRARY_KEY), null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        gameLibrary = gson.fromJson(json, type);
        setList();
    }

    private void listeners() {
        addGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameName.getText().toString().equals("")) {
                    String game = gameName.getText().toString();
                    gameLibrary.add(game);
                    gameName.setText("");
                    setList();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter a Name First", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gameList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), gameLibrary.get(i)+" removed from your game library",Toast.LENGTH_SHORT).show();
                gameLibrary.remove(i);
                setList();
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        saveLibrary(gameLibrary, getString(R.string.GAME_LIBRARY_KEY));
        super.onDestroy();
    }

    private void saveLibrary(ArrayList<String> list, String key) {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_PAGE), MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    private void setList() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameLibrary);
        gameList.setAdapter(adapter);
    }


    private void setIDs() {
        gameName = (EditText)findViewById(R.id.game_library_game_name);
        addGame = (Button)findViewById(R.id.game_library_add_game_name);
        gameList = (ListView)findViewById(R.id.game_library_game_list);
    }
}
