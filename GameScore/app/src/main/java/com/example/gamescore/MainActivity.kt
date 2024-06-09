package com.example.gamescore

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var score1: Int = 0
    private var score2: Int = 0

    private lateinit var textViewScore1: TextView
    private lateinit var textViewScore2: TextView

    override fun onCreate(savedInstanceState: Bundle?) { // создание объекта активити (не виден пользователю)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        textViewScore1 = findViewById(R.id.textViewScore1)
        textViewScore2 = findViewById(R.id.textViewScore2)

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1")
            score2 = savedInstanceState.getInt("score2")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateScore(score1, textViewScore1)
        updateScore(score2, textViewScore2)

        textViewScore1.setOnClickListener {
            Log.d("MainActivity", "Clicked textViewScore1")
            score1++
            updateScore(score1, textViewScore1)
        }

        textViewScore2.setOnClickListener {
            Log.d("MainActivity", "Clicked textViewScore2")
            score2++
            updateScore(score2, textViewScore2)
        }
    }

    override fun onStart() { // активити становится видимой, но с ней еще нельзя взаимодействовать
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() { // с активити можно взаимодействовать
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause") // с активити нельзя взаимодействовать, но она приэтом видна
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop") // активити становится невидимой, но она еще существует
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart") // если активити не уничтожается, и мы хотим заново ее открыть
    }

    private fun updateScore(score: Int, textViewScore: TextView) {
        textViewScore.text = score.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score1", score1)
        outState.putInt("score2", score2)
        Log.d("MainActivity", "onSaveInstanceState")
    }

    override fun onDestroy() { // активити удаляется
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}