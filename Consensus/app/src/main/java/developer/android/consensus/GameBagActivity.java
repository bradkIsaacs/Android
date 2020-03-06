package developer.android.consensus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameBagActivity extends AppCompatActivity {

    private ArrayList<String> gameLibrary;
    private ArrayList<String> gameBag;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    ListView gameLibraryList, gameBagList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_bag);
        gameBag = new ArrayList();
        setIDs();
        //loadBag();
        loadLibrary();
        listeners();
    }

    private void loadBag() {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_PAGE), MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(getString(R.string.GAME_BAG_KEY), null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        gameBag = gson.fromJson(json, type);
        setBagList();
    }

    private void listeners() {
        gameLibraryList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), gameLibrary.get(i)+" moved to your game bag", Toast.LENGTH_SHORT).show();
                gameBag.add(String.valueOf(gameLibrary.get(i)));
                gameLibrary.remove(i);
                setBagList();
                setLibraryList();
                return true;
            }
        });
        gameBagList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), gameBag.get(i)+" moved back to you library",Toast.LENGTH_SHORT).show();
                gameLibrary.add(String.valueOf(gameBag.get(i)));
                gameBag.remove(i);
                setLibraryList();
                setBagList();
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        saveBag(gameBag, getString(R.string.GAME_BAG_KEY));
        super.onDestroy();
    }

    private void saveBag(ArrayList<String> list, String key) {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_PAGE), MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    private void setBagList() {
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameBag);
        gameBagList.setAdapter(adapter2);
    }

    private void setLibraryList() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameLibrary);
        gameLibraryList.setAdapter(adapter);
    }

    private void loadLibrary() {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_PAGE), MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(getString(R.string.GAME_LIBRARY_KEY), null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        gameLibrary = gson.fromJson(json, type);
        setLibraryList();
    }

    private void setIDs() {
        gameLibraryList = (ListView)findViewById(R.id.game_bag_library_list);
        gameBagList = (ListView)findViewById(R.id.game_bag_bag_list);
    }
}
