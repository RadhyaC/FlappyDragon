package com.example.flappybird

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

class Bird (context: Context) {
    private var birdBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.dragon2)
    var x: Float = 100f
    var y: Float = 100f
    var velocity: Float = 0f

    //plotting dragon on canvas
    fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawBitmap(birdBitmap, x, y, paint)
    }

    // increasing y value by velocity, then increasing velocity by 1
    fun update() {
        y += velocity
        velocity +=1f
    }

    fun flap() {
        velocity = -20f
    }

    fun getRectangle(): Rect {
        return Rect(x.toInt(), y.toInt(), (x + birdBitmap.width).toInt(),  (y + birdBitmap.height).toInt())
    }
}