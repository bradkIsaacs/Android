package com.vogella.android.indentfontchooser

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val FONT_REQUEST_CODE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.btn_fontchooser) as Button;
        btn.setOnClickListener { view ->
            val i = Intent("ACTION_RETRIVE_FONT")
            startActivityForResult(i,FONT_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null) {
            val display_tf: TextView = findViewById(R.id.tv_typeface) as TextView
            val display_s: TextView = findViewById(R.id.tv_style) as TextView
            val getTYPEFACE = data.getIntExtra("typeface", 6)
            val getSTYLE = data.getIntExtra("style", 6)
            val alpha = data.getIntExtra("alpha", 0)
            val red = data.getIntExtra("red", 0)
            val green = data.getIntExtra("green", 0)
            val blue = data.getIntExtra("blue", 0)
            display_s.setText("" + getStyle(getSTYLE))
            display_tf.setText("" + getTypeFace(getTYPEFACE))
            display_s.setTextColor(Color.argb(alpha, red, green, blue))
            display_tf.setTextColor(Color.argb(alpha, red, green, blue))
            display_tf.setTypeface(setTypeFace(getTYPEFACE), Typeface.NORMAL)
            display_s.setTypeface(Typeface.DEFAULT, getSTYLE)
        }
    }

    fun getTypeFace(x : Int):String{
        when(x){
            1 -> return "DEFAULT"
            2 -> return "DEFAULT BOLD"
            3 -> return "MONOSPACE"
            4 -> return "SANS SERIF"
            5 -> return "SERIF"
        }
        return "DEFAULT"
    }

    fun getStyle(x : Int):String{
        when(x){
            0 -> return "NORMAL"
            1 -> return "BOLD"
            2 -> return "ITALIC"
            3 -> return "BOLD ITALIC"
        }
        return "NORMAL"
    }

    fun setTypeFace(num: Int): Typeface? {
        when(num){
            1 -> return Typeface.DEFAULT
            2 -> return Typeface.DEFAULT_BOLD
            3 -> return Typeface.MONOSPACE
            4 -> return Typeface.SANS_SERIF
            5 -> return Typeface.SERIF
        }
        return Typeface.DEFAULT
    }
}