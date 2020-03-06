package developer.android.arboretumscorepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set Buttons
        val new_game = findViewById<Button>(R.id.main_new_game)
        val history = findViewById<Button>(R.id.main_game_history)
        // Set onClick Listeners
        new_game.setOnClickListener { startActivity(Intent(this,PlayerActivity::class.java)) }
    }
}
