package com.example.flappybird

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, holder: SurfaceView) : SurfaceView(context), SurfaceHolder.Callback {

    private lateinit var gameThread: GameThread
    private val bird = Bird(context)
    private val tower = Tower(context, 1000f, 500)

    init {
        initView(holder)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (!gameThread.isRunning)
        {
            gameThread = GameThread(holder, bird, tower)
            gameThread.start()
        }
        else{
            gameThread.start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        if (gameThread.isRunning){
            gameThread.updateRunningState(false)
            var retry: Boolean = true
            while (retry) {
                try {
                    gameThread.join()
                    retry = false
                }
                catch (e: InterruptedException) { //issue here, must figure out
                }
            }
        }
    }

    private fun initView(holder: SurfaceHolder) {
        holder.addCallback(this)
        isFocusable = true

        gameThread = GameThread(holder, bird, tower)
    }

}