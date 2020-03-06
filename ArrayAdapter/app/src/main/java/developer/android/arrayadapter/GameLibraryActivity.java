package developer.android.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameLibraryActivity extends AppCompatActivity {

    EditText gameName, minPlayer, maxPlayer;
    Button addGame;
    ListView libraryList;

    ArrayList<BoardGame> gameLibrary;
    MyCustomAdaptor libraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_library);
        gameLibrary = new ArrayList<>();
        findIDs();
        loadLibrary();
        listeners();
    }

    private void loadLibrary() {
        SharedPreferences  sharedPreferences = getSharedPreferences("Games", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("GAME_LIBRARY",null);
        Type type = new TypeToken<ArrayList<BoardGame>>() {}.getType();
        gameLibrary = gson.fromJson(json, type);
        setLibrary();
    }

    private void listeners() {
        addGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BoardGame game = new BoardGame(gameName.getText().toString(), Integer.parseInt(minPlayer.getText().toString()), Integer.parseInt(maxPlayer.getText().toString()));
                gameLibrary.add(game);
                resetEdits();
                setLibrary();
            }
        });

        libraryList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), gameLibrary.get(i).getName()+" removed from your game library",Toast.LENGTH_SHORT).show();
                gameLibrary.remove(i);
                setLibrary();
                return true;
            }
        });
    }

    private void resetEdits() {
        gameName.setText("");
        minPlayer.setText("");
        maxPlayer.setText("");
    }

    @Override
    protected void onDestroy() {
        saveLibrary();
        super.onDestroy();
    }

    private void saveLibrary() {
        SharedPreferences  sharedPreferences = getSharedPreferences("Games", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(gameLibrary);
        editor.putString("GAME_LIBRARY", json);
        editor.apply();
    }

    private void setLibrary() {
        libraryAdapter = new MyCustomAdaptor(getApplicationContext(), gameLibrary);
        libraryList.setAdapter(libraryAdapter);
    }

    private void findIDs() {
        gameName = findViewById(R.id.game_library_name);
        minPlayer = findViewById(R.id.game_library_min_player);
        maxPlayer = findViewById(R.id.game_library_max_player);
        addGame = findViewById(R.id.game_library_add_game);
        libraryList = findViewById(R.id.game_library_list_view);
    }
}
