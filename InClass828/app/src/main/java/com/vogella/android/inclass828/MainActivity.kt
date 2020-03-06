package com.vogella.android.inclass828

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_help -> {
                tv.setText("Welcome to the help menu")
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Action Listener for ToogleButton2=1: Change Visibility of TextBox
    fun changeVisibility(v: View){
        if (toggleButton1.isChecked){
            tv.visibility = View.INVISIBLE
        }
        else{
            tv.visibility = View.VISIBLE
        }
    }

    //Action Listener for ToogleButton2: Change Background Color of TextBox
    fun changeBackground(v: View){
        if (toggleButton2.isChecked) {
            tv.setBackgroundColor(Color.parseColor("#ff0000"))
        } else {
            tv.setBackgroundColor(Color.parseColor("#ffffff"))
        }
    }
}
