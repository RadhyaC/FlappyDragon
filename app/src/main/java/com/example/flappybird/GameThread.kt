package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Paint
import android.os.SystemClock
import android.util.Log
import android.view.SurfaceHolder

class GameThread(private val surfaceHolder: SurfaceHolder,  private val bird: Bird, private val tower: Tower) : Thread() {

    var isRunning: Boolean = false;

    private var startTime: Long = 0
    private var loopTime: Long = 0

    private val DELAY: Long = 33

    init {
        isRunning = true
    }

    override fun run() {
        while (isRunning) {
            startTime = SystemClock.uptimeMillis()

            val canvas: Canvas = surfaceHolder.lockCanvas(null)
            if (canvas != null)
            {
                synchronized(surfaceHolder) {

                    bird.draw(canvas, Paint())
                    tower.draw(canvas)

                    //update the stuff
                    bird.update()
                    tower.update()

                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
            loopTime = SystemClock.uptimeMillis() - startTime


            if (loopTime < DELAY) {
                try {
                    Thread.sleep(DELAY - loopTime)
                }
                catch (e: InterruptedException) {}
                Log.e("Interrupted", "Interrupted while sleeping")
            }
        }
    }

    fun updateRunningState( state: Boolean) {
        isRunning = state
    }
}