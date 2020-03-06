package developer.android.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationActivity extends AppCompatActivity {

    Button gameLibrary, gameBag, sendGameBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        findIDs();
        listeners();
    }

    private void listeners() {
        gameLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameLibraryActivity.class));
            }
        });
        gameBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameBagActivity.class));
            }
        });
        sendGameBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SendGameBagActivity.class));
            }
        });
    }

    private void findIDs() {
        gameLibrary = findViewById(R.id.game_library_activity);
        gameBag = findViewById(R.id.game_bag_activity);
        sendGameBag = findViewById(R.id.send_game_bag_activity);
    }
}
