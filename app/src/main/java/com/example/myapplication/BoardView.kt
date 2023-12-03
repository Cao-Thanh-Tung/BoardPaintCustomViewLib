package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.util.LinkedList

/**
 * TODO: document your custom view class.
 */
class BoardView : View {
    private lateinit var paint: Paint
    private lateinit var points : LinkedList<Float>
    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 20f
        points = LinkedList<Float>()

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        this.setOnTouchListener { v, event ->
            addPoint(event.x,event.y)
            true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPoints(points.toFloatArray(),paint)
    }

    public fun addPoint(x:Float, y:Float){
        points.add(x)
        points.add(y)
        invalidate()
    }
    public fun clear(){
        points.clear()
        invalidate()
    }
}