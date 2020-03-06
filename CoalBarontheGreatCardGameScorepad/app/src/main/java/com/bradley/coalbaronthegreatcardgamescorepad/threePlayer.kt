package com.bradley.coalbaronthegreatcardgamescorepad

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

abstract class threePlayer : AppCompatActivity() {

    internal abstract var p1Name: EditText
    internal abstract var p1LC: EditText
    internal abstract var p1OC: EditText
    internal abstract var p1SC: EditText
    internal abstract var p1ST: EditText
    internal abstract var p1OBJ: EditText
    internal abstract var p1SCORE: EditText
    internal abstract var p2Name: EditText
    internal abstract var p2LC: EditText
    internal abstract var p2OC: EditText
    internal abstract var p2SC: EditText
    internal abstract var p2ST: EditText
    internal abstract var p2OBJ: EditText
    internal abstract var p2SCORE: EditText
    internal abstract var p3Name: EditText
    internal abstract var p3LC: EditText
    internal abstract var p3OC: EditText
    internal abstract var p3SC: EditText
    internal abstract var p3ST: EditText
    internal abstract var p3OBJ: EditText
    internal abstract var p3SCORE: EditText
    internal var gameplay = ArrayList<String>()
    internal var sdf = SimpleDateFormat("MM/dd/yy")
    internal var currentDateandDay = sdf.format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_player_game)
        p1Name = findViewById<View>(R.id.p1Name) as EditText
        p1LC = findViewById<View>(R.id.p1LC) as EditText
        p1OC = findViewById<View>(R.id.p1OC) as EditText
        p1SC = findViewById<View>(R.id.p1SC) as EditText
        p1ST = findViewById<View>(R.id.p1ST) as EditText
        p1OBJ = findViewById<View>(R.id.p1OBC) as EditText
        p1SCORE = findViewById<View>(R.id.p1F) as EditText
        p2Name = findViewById<View>(R.id.p2Name) as EditText
        p2LC = findViewById<View>(R.id.p2LC) as EditText
        p2OC = findViewById<View>(R.id.p2OC) as EditText
        p2SC = findViewById<View>(R.id.p2SC) as EditText
        p2ST = findViewById<View>(R.id.p2ST) as EditText
        p2OBJ = findViewById<View>(R.id.p2OBC) as EditText
        p2SCORE = findViewById<View>(R.id.p2F) as EditText
        p3Name = findViewById<View>(R.id.p3Name) as EditText
        p3LC = findViewById<View>(R.id.p3LC) as EditText
        p3OC = findViewById<View>(R.id.p3OC) as EditText
        p3SC = findViewById<View>(R.id.p3SC) as EditText
        p3ST = findViewById<View>(R.id.p3ST) as EditText
        p3OBJ = findViewById<View>(R.id.p3OBC) as EditText
        p3SCORE = findViewById<View>(R.id.p3F) as EditText
    }

    //On click Method
    fun scores(v: View) {
        if (p1Name.text.toString() != "" &&
                p1LC.text.toString() != "" &&
                p1OC.text.toString() != "" &&
                p1SC.text.toString() != "" &&
                p1ST.text.toString() != "" &&
                p1OBJ.text.toString() != "" &&
                p2Name.text.toString() != "" &&
                p2LC.text.toString() != "" &&
                p2OC.text.toString() != "" &&
                p2SC.text.toString() != "" &&
                p2ST.text.toString() != "" &&
                p2OBJ.text.toString() != "" &&
                p3Name.text.toString() != "" &&
                p3LC.text.toString() != "" &&
                p3OC.text.toString() != "" &&
                p3SC.text.toString() != "" &&
                p3ST.text.toString() != "" &&
                p3OBJ.text.toString() != "") {
            p1SCORE.setText((Integer.parseInt(p1LC.text.toString())
                    + Integer.parseInt(p1OC.text.toString())
                    + Integer.parseInt(p1SC.text.toString())
                    + Integer.parseInt(p1ST.text.toString())
                    + Integer.parseInt(p1OBJ.text.toString())).toString() + "")
            p2SCORE.setText((Integer.parseInt(p2LC.text.toString())
                    + Integer.parseInt(p2OC.text.toString())
                    + Integer.parseInt(p2SC.text.toString())
                    + Integer.parseInt(p2ST.text.toString())
                    + Integer.parseInt(p2OBJ.text.toString())).toString() + "")
            p3SCORE.setText((Integer.parseInt(p3LC.text.toString())
                    + Integer.parseInt(p3OC.text.toString())
                    + Integer.parseInt(p3SC.text.toString())
                    + Integer.parseInt(p3ST.text.toString())
                    + Integer.parseInt(p3OBJ.text.toString())).toString() + "")
            save()
        } else {
            Toast.makeText(this, "One or more of the input fields are empty", Toast.LENGTH_LONG).show()
        }

    }

    private fun save() {
        load()
        //Build Array
        gameplay.add(currentDateandDay)
        gameplay.add(p1Name.text.toString() + ": " + p1SCORE.text.toString())
        gameplay.add(p2Name.text.toString() + ": " + p2SCORE.text.toString())
        gameplay.add(p3Name.text.toString() + ": " + p3SCORE.text.toString())
        gameplay.add("-----------------------------------------------------------")
        val sb = StringBuilder()
        for (i in gameplay.indices) {
            sb.append(gameplay[i]).append(",")
        }
        val settings = getSharedPreferences("PREFS", 0)
        val edit = settings.edit()
        edit.putString("Array", sb.toString())
        edit.commit()
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
