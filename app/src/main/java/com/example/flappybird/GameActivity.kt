package com.example.flappybird

import android.os.Bundle
import android.view.SurfaceView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        val surfaceView: SurfaceView = findViewById(R.id.gameSurfaceView)

        gameView = GameView(this, surfaceView)
        surfaceView.holder.addCallback(gameView)
        setContentView(gameView)
    }
}