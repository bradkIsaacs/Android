package com.vogella.android.fontchooser

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val sliderAlpha = findViewById<SeekBar>(R.id.sliderAlpha)
        val sliderRed = findViewById<SeekBar>(R.id.sliderRed)
        val sliderGreen = findViewById<SeekBar>(R.id.sliderGreen)
        val sliderBlue = findViewById<SeekBar>(R.id.sliderBlue)
        val sliderSize = findViewById<SeekBar>(R.id.sliderSize)
        val valueAlpha = findViewById<TextView>(R.id.valueAlpha)
        val valueRed = findViewById<TextView>(R.id.valueRed)
        val valueGreen = findViewById<TextView>(R.id.valueGreen)
        val valueBlue = findViewById<TextView>(R.id.valueBlue)
        val valueSize = findViewById<TextView>(R.id.valueSize)
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
        sliderSize.min = 12 //set minimum 12 androids suggested minimum size
        sliderAlpha.max = 255 //changes the value range to 0-255
        sliderRed.max = 255 //changes the value range to 0-255
        sliderGreen.max = 255 //changes the value range to 0-255
        sliderBlue.max = 255 //changes the value range to 0-255
        sliderAlpha.setProgress(255) //sets slider start value at 255 a.k.a fully visible
        sliderAlpha.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valueAlpha.setText("Alpha: ${sliderAlpha.progress.toString()}")
                changeText.setTextColor(Color.argb(sliderAlpha.progress, sliderRed.progress, sliderGreen.progress,sliderBlue.progress))
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        sliderRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valueRed.setText("Red: ${sliderRed.progress.toString()}")
                changeText.setTextColor(Color.argb(sliderAlpha.progress, sliderRed.progress, sliderGreen.progress,sliderBlue.progress))
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        sliderGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valueGreen.setText("Green: ${sliderGreen.progress.toString()}")
                changeText.setTextColor(Color.argb(sliderAlpha.progress, sliderRed.progress, sliderGreen.progress,sliderBlue.progress))
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        sliderBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valueBlue.setText("Blue: ${sliderBlue.progress.toString()}")
                changeText.setTextColor(Color.argb(sliderAlpha.progress, sliderRed.progress, sliderGreen.progress,sliderBlue.progress))
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        sliderSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valueSize.setText("Size: ${sliderSize.progress.toString()}")
                changeText.setTextSize(sliderSize.progress.toFloat())
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        val sendFont : Button = findViewById(R.id.btn_save) as Button
        if(intent.action=="ACTION_RETRIVE_FONT"){ //Make send Font visible if called for intent
            sendFont.visibility = View.VISIBLE
            sendFont.isClickable = true
        }
        sendFont.setOnClickListener { view ->
            val s = sharedPreferences.getInt("style", 0)
            val tf = sharedPreferences.getInt("typeface", 1)
            val i = Intent()
            i.putExtra("typeface", tf)
            i.putExtra("style", s)
            i.putExtra("alpha", sliderAlpha.progress)
            i.putExtra("red", sliderRed.progress)
            i.putExtra("green", sliderGreen.progress)
            i.putExtra("blue", sliderBlue.progress)
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }

    fun setDefault(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("typeface", 1)
        editor.commit();
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setDefault_Bold(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("typeface", 2)
        editor.commit();
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setMonospace(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("typeface", 3)
        editor.commit();
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setSans_Serif(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("typeface", 4)
        editor.commit();
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setSerif(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("typeface", 5)
        editor.commit();
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setBold(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("style", Typeface.BOLD)
        editor.commit()
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setBold_Italic(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("style", Typeface.BOLD_ITALIC)
        editor.commit()
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setItalic(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("style", Typeface.ITALIC)
        editor.commit()
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun setNormal(view: View) {
        val sharedPreferences = getSharedPreferences("SP_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("style", Typeface.NORMAL)
        editor.commit()
        val changeText = findViewById<TextView>(R.id.playtext)
        changeText.setTypeface(getTypeFace(sharedPreferences.getInt("typeface", 1)), sharedPreferences.getInt("style", 0))
    }
    fun getTypeFace(num: Int): Typeface? {
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
