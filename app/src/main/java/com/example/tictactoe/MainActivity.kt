package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun playWithComputer(view: View){
        val name = enteredName.text.toString()
        val intent = Intent(this, AutoGameActivity::class.java)
        intent.putExtra("Entered Name", name)
        startActivity(intent)
    }

    fun playWithFriend(view: View){
        val name = enteredName.text.toString()
        val intent = Intent(this, TwoPlayerActivity::class.java)
        intent.putExtra("Entered Name", name)
        startActivity(intent)
    }
}