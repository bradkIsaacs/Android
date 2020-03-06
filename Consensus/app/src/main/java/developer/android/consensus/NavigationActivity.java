package developer.android.consensus;

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
        setIDs();
        listeners();
    }

    private void setIDs() {
        gameLibrary = (Button)findViewById(R.id.navigation_game_library);
        gameBag = (Button)findViewById(R.id.navigation_game_bag);
        sendGameBag = (Button)findViewById(R.id.navigation_send_game_bag);
    }

    private void listeners() {
        gameLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGameLibraryActivity();
            }
        });
        gameBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGameBagActivity();
            }
        });
        sendGameBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startSendGameBageActivity(); }
        });
    }

    private void startSendGameBageActivity(){
        Intent startSendGameBagIntent = new Intent(this, SendGameBagActivity.class);
        startActivity(startSendGameBagIntent);
    }

    private void startGameBagActivity() {
        Intent startGameBagIntent = new Intent(this, GameBagActivity.class);
        startActivity(startGameBagIntent);
    }

    private void startGameLibraryActivity() {
        Intent startGameLibraryIntent = new Intent(this, GameLibraryActivity.class);
        startActivity(startGameLibraryIntent);
    }
}
