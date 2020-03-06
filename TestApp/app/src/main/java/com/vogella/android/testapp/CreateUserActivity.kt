package com.vogella.android.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun onClick(v : View){
        var text = findViewById(R.id.username) as EditText
        Toast.makeText(this, "User ${text.text} Created", Toast.LENGTH_LONG).show()
    }
}
