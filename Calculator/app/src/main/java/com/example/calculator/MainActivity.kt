package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextResponse: EditText = findViewById(R.id.user_response)
        val clickButton: Button = findViewById(R.id.response_button)
        val textViewIncorrect: TextView = findViewById(R.id.incorrect_system_response)
        val textViewCorrect: TextView = findViewById(R.id.correct_system_response)
        val textViewExample: TextView = findViewById(R.id.example)

        textViewExample.setText("10 + 10 = ?")

        clickButton.setOnClickListener {
            if (editTextResponse.text.toString().toInt() == 20) {
                textViewCorrect.visibility = View.VISIBLE
                textViewIncorrect.visibility = View.GONE
            } else {
                textViewIncorrect.visibility = View.VISIBLE
                textViewCorrect.visibility = View.GONE
            }
        }
    }
}