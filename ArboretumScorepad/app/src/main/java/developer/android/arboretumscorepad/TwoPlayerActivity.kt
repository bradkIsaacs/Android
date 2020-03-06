package developer.android.arboretumscorepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TwoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player)
        val player1 = findViewById<TextView>(R.id.two_player_p1)
        player1.setText(PlayerActivity.player1)
    }
}
