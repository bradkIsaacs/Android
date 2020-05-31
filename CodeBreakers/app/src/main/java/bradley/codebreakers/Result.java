package bradley.codebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView display;
    boolean wl;
    int num;
    String[] array;
    Intent intent;
    MediaPlayer victory, fail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        stopService(new Intent(this, MyService.class));
        display = findViewById(R.id.tv_result_display);
        victory = MediaPlayer.create(this, R.raw.victory);
        fail = MediaPlayer.create(this, R.raw.fail);
        intent = getIntent();
        wl = intent.getBooleanExtra("b", true);
        num = intent.getIntExtra("g",0);
        array = intent.getStringArrayExtra("c");
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<array.length; i++){
            temp.append(array[i]+" ");
        }
        if(wl){
            victory.start();
            display.setText("You Have Broken The Code"+"\n"+"It took you "+num+" guesses"+"\n"+temp);
        }
        else{
            fail.start();
            display.setText("You failed to break the code within "+num+" guesses\nThe code was: "+temp);
        }
    }
}
