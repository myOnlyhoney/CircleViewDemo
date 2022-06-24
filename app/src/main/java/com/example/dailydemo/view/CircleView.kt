package com.example.dailydemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.dailydemo.R


/**
 * 自定义view，绘制一个圆
 */
class CircleView : View {
    private var mPaint: Paint? = null
    private var mColor: Int = -1

    constructor(context: Context):super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet):this(context, attrs, 0){

        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CircleView)
        //解析该自定义属性
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.BLUE)
        //解析后释放资源
        a.recycle()
        init()
    }

    private fun init() {
        mPaint = Paint()
        //设置画笔颜色
        mPaint?.color = mColor
        //设置画笔宽度
        mPaint?.strokeWidth = 5f
        //设置画笔模式为填充
        mPaint?.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //获取padding
        val padLeft = paddingLeft
        val padRight = paddingRight
        val padTop = paddingTop
        val padBottom = paddingBottom
        //获取圆的宽高
        val width = width - padLeft - padRight
        val height = height - padTop - padBottom

//设置圆的半径，为宽或者高的最小值的二分之一
        val r = width.coerceAtMost(height) / 2

        canvas?.drawCircle(
            padLeft + width / 2.toFloat(),
            padTop + height / 2.toFloat(),
            r.toFloat(),
            mPaint!!
        )
    }
}

