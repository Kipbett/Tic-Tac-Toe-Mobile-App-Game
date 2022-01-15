package com.wolf.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        var button4 = findViewById<Button>(R.id.button4)
        var button5 = findViewById<Button>(R.id.button5)
        var button6 = findViewById<Button>(R.id.button6)
        var button7 = findViewById<Button>(R.id.button7)
        var button8 = findViewById<Button>(R.id.button8)
        var button9 = findViewById<Button>(R.id.button9)
    }

    fun buClick(view: android.view.View) {
        val buSelected = view as Button

        var cellID = 0
        when(buSelected.id){
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9

        }
        Log.d("buClick", buSelected.id.toString())
        Log.d("buclick: cellID: ", cellID.toString())
        playGame(cellID, buSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId:Int, buID:Button){
        if (activePlayer == 1){
            buID.text = "X"
            buID.setBackgroundResource(R.color.teal_200)
            player1.add(cellId)
            activePlayer = 0
            autoPlay()
        } else {
            buID.text = "Y"
            buID.setBackgroundResource(R.color.purple_200)
            player2.add(cellId)
            activePlayer = 1
        }

        buID.isEnabled = false

        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

//        Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

//        Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2

//        Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

//        Column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2

//        Column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2

//        Column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        if(winner == 1)
            Toast.makeText(this, "Player 1 Wins The game", Toast.LENGTH_LONG).show()
        else if(winner == 2)
            Toast.makeText(this, "Player 2 Wind The Game", Toast.LENGTH_LONG).show()
    }

    fun autoPlay(){
        var emptyCells = ArrayList<Int>()

        for(cellID in 1..9){
            if (!(player1.contains(cellID)) || !(player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randomIndex]
        var buSelected:Button?
        buSelected = when(cellId){
            1 -> findViewById(R.id.button1)
            2 -> findViewById(R.id.button2)
            3 -> findViewById(R.id.button3)
            4 -> findViewById(R.id.button4)
            5 -> findViewById(R.id.button5)
            6 -> findViewById(R.id.button6)
            7 -> findViewById(R.id.button7)
            8 -> findViewById(R.id.button8)
            9 -> findViewById(R.id.button9)
            else -> findViewById(R.id.button1)
        }

        playGame(cellId, buSelected)
    }
}