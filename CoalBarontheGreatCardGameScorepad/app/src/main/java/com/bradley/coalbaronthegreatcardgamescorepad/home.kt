package com.bradley.coalbaronthegreatcardgamescorepad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
    }

    fun twoPlayerGame(v: View) {
        startActivity(Intent(this, twoPlayer::class.java))
    }

    fun threePlayerGame(v: View) {
        startActivity(Intent(this, threePlayer::class.java))
    }

    fun fourPlayerGame(v: View) {
        startActivity(Intent(this, fourPlayer::class.java))
    }

    fun viewGameHistoy(v: View) {
        startActivity(Intent(this, gameHistory::class.java))
    }
}
