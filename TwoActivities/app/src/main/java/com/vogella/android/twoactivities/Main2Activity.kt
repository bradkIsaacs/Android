package com.vogella.android.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val input: EditText = findViewById(R.id.et_num)
        val ok: Button = findViewById(R.id.btn_send)
        val cancel: Button = findViewById(R.id.btn_cancel)
        ok.setOnClickListener {
            val returnIntent : Intent = Intent()
            returnIntent.putExtra("number", input.text.toString().toInt())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
        cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
