package com.vogella.android.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var REQUEST_CODE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btn_get)
        button.setOnClickListener {
            val i: Intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(i, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (data != null){
                tv_recieved.setText("${data.getIntExtra("number",0)}")
            }else {
                tv_recieved.setText("No Data Found")
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            tv_recieved.setText("Canceled")
        }
    }
}
