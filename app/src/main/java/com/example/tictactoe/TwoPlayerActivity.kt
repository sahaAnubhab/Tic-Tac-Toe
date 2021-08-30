package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_auto_game.*
import kotlinx.android.synthetic.main.activity_main.*

class TwoPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player)

        val playerName = intent.getStringExtra("Entered Name")
        enteredPlayerName.text = "Welcome $playerName"
    }
    var activePlayer = 0
    private var gameState : Array<Int> = arrayOf(2,2,2,2,2,2,2,2,2)
    private val winState : Array<Array<Int>> = arrayOf(arrayOf(0,1,2), arrayOf(3,4,5), arrayOf(6,7,8), arrayOf(0,4,8), arrayOf(2,4,6),
        arrayOf(0,3,6), arrayOf(1,4,7), arrayOf(2,5,8))
    fun playerClick(view: View){
        val img : ImageView = view as ImageView
        val tappedImage = img.tag.toString().toInt()
        if(gameState[tappedImage] == 2) {
            if (activePlayer % 2 == 0) {
                img.setImageResource(R.drawable.cross)
                activePlayer = 1
                gameState[tappedImage] = 0
                textView.text = "O's turn to play"
            } else {
                img.setImageResource(R.drawable.zero)
                activePlayer =0
                gameState[tappedImage] = 1
                textView.text = "X's turn to play"
            }
        }
        for (win in winState){
            if(gameState[win[0]]==gameState[win[1]]&& gameState[win[1]]==gameState[win[2]] && gameState[win[0]]!=2) {
                gameState = arrayOf(3,3,3,3,3,3,3,3,3)
                if( activePlayer == 1){
                    textView.text = "X has won"
                }
                if( activePlayer == 0){
                    textView.text = "O has won"
                }
            }
        }

    }

    fun reset(view: View){
        box0.setImageResource(0)
        box1.setImageResource(0)
        box2.setImageResource(0)
        box3.setImageResource(0)
        box4.setImageResource(0)
        box5.setImageResource(0)
        box6.setImageResource(0)
        box7.setImageResource(0)
        box8.setImageResource(0)
        gameState= arrayOf(2,2,2,2,2,2,2,2,2)
        activePlayer = 0
    }

}