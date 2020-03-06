package developer.android.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameBagActivity extends AppCompatActivity {

    ListView libraryList, bagList;

    ArrayList<BoardGame> gameLibrary, gameBag;
    MyCustomAdaptor libraryAdapter, bagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_bag);
        gameLibrary = new ArrayList<>();
        gameBag = new ArrayList<>();
        findIDs();
        loadLibrary();
        listeners();
    }

    private void listeners() {
        libraryList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), gameLibrary.get(i).getName()+" moved to your game bag",Toast.LENGTH_SHORT).show();
                gameBag.add(new BoardGame(gameLibrary.get(i).getName(), gameLibrary.get(i).getMin_player(), gameLibrary.get(i).getMax_player()));
                gameLibrary.remove(i);
                setBag();
                setLibrary();
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveBag();
    }

    private void saveBag() {
        SharedPreferences  sharedPreferences = getSharedPreferences("Games", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(gameBag);
        editor.putString("GAME_BAG", json);
        editor.apply();
    }

    private void setBag() {
        bagAdapter = new MyCustomAdaptor(getApplicationContext(), gameBag);
        bagList.setAdapter(bagAdapter);
    }

    private void loadLibrary() {
        SharedPreferences sharedPreferences = getSharedPreferences("Games", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("GAME_LIBRARY",null);
        Type type = new TypeToken<ArrayList<BoardGame>>() {}.getType();
        gameLibrary = gson.fromJson(json, type);
        setLibrary();
    }

    private void setLibrary() {
        libraryAdapter = new MyCustomAdaptor(getApplicationContext(), gameLibrary);
        libraryList.setAdapter(libraryAdapter);
    }

    private void findIDs() {
        libraryList = findViewById(R.id.game_bag_game_library_list);
        bagList = findViewById(R.id.game_bag_game_bag_list);
    }
}
