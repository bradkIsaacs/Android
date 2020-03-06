package developer.android.arboretumscorepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class PlayerActivity : AppCompatActivity() {

    companion object{
        var player1 = ""
        var player2 = ""
        var player3 = ""
        var player4 = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        // Set Views
        val p1 = findViewById<EditText>(R.id.player_one)
        val p2 = findViewById<EditText>(R.id.player_two)
        val p3 = findViewById<EditText>(R.id.player_three)
        val p4 = findViewById<EditText>(R.id.player_four)
        val submit = findViewById<Button>(R.id.player_submit)
        //Set Button Listener
        submit.setOnClickListener {
            //Save Names as Strings
            player1 = p1.text.toString()
            player2 = p2.text.toString()
            player3 = p3.text.toString()
            player4 = p4.text.toString()
            //How Many Players
            if(!p1.text.toString().equals("") && !p2.text.toString().equals("") && !p3.text.toString().equals("") && !p4.text.toString().equals("")){
                Toast.makeText(this, "Four Player Game Started", Toast.LENGTH_LONG).show()
            }
            else if(!p1.text.toString().equals("") && !p2.text.toString().equals("") && !p3.text.toString().equals("")){
                Toast.makeText(this, "Three Player Game Started", Toast.LENGTH_LONG).show()
            }
            else if(!p1.text.toString().equals("") && !p2.text.toString().equals("")){
                startActivity(Intent(this, TwoPlayerActivity::class.java))
            }
            else {
                Toast.makeText(this, "There must be atleast a Player 1 and Player 2", Toast.LENGTH_LONG).show()
            }
        }
    }
}
