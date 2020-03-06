package com.bradley.coalbaronthegreatcardgamescorepad

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

import java.util.ArrayList

abstract class gameHistory : AppCompatActivity() {

    internal abstract var display: TextView
    internal var gameplay = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_history)
        display = findViewById(R.id.textView)
        //Load List
        load()
        //Print List
        displayList()
    }

    fun displayList() {
        val sb = StringBuilder()
        for (i in gameplay.indices) {
            sb.append(gameplay[i]).append("\n")
        }
        display.text = sb.toString()
    }

    private fun load() {
        val settings = getSharedPreferences("PREFS", 0)
        val items = settings.getString("Array", "")
        val arr = items!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val arrayList = ArrayList<String>()
        for (i in arr.indices) {
            arrayList.add(arr[i])
        }
        gameplay = arrayList
    }
}