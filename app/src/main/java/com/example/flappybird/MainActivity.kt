package com.example.flappybird

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var playBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        playBtn = findViewById(R.id.playBtn)

        playBtn.setOnClickListener{
            //Toast.makeText(this, "Play!", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

    }
}