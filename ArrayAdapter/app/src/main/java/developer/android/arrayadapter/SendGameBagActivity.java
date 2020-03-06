package developer.android.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SendGameBagActivity extends AppCompatActivity {

    Button listen, listDevices;
    TextView status;
    ListView listOfDevices, gameBag;

    ArrayList<BoardGame> gameBagArray;
    MyCustomAdaptor gameBagAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_game_bag);
        findIDs();
        loadGameBag();
    }

    private void loadGameBag() {
        SharedPreferences sharedPreferences = getSharedPreferences("Games", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("GAME_BAG",null);
        Type type = new TypeToken<ArrayList<BoardGame>>() {}.getType();
        gameBagArray = gson.fromJson(json, type);
        setBag();
    }

    private void setBag() {
        gameBagAdapter = new MyCustomAdaptor(getApplicationContext(), gameBagArray);
        gameBag.setAdapter(gameBagAdapter);
    }

    private void findIDs() {
        listen = findViewById(R.id.send_game_bag_listen);
        listDevices = findViewById(R.id.send_game_bag_list_devices);
        status = findViewById(R.id.send_game_bag_status);
        listOfDevices = findViewById(R.id.send_game_bag_list_of_devices);
        gameBag = findViewById(R.id.send_game_bag_game_bag);
    }
}
