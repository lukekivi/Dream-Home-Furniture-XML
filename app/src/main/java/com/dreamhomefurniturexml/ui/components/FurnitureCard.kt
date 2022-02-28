package com.dreamhomefurniturexml.ui.components

import android.content.Context
import android.graphics.Canvas
import android.widget.LinearLayout

data class FurnitureCardData(
    val title: String,
    val price: String,
    val vendorTitle: String,
    val collection: String,
    val imageUrl: String?
)

class FurnitureCard(context: Context): LinearLayout(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true



        return true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

}