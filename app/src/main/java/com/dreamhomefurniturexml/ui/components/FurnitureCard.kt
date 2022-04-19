package com.dreamhomefurniturexml.ui.components

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.dreamhomefurniturexml.R
import com.squareup.picasso.Picasso

data class FurnitureCardData(
    val title: String,
    val price: String,
    val vendorTitle: String,
    val collection: String,
    val imageUrl: String?
)

class FurnitureCard(context: Context): ConstraintLayout(context) {

    private val furnitureImage: ImageView
    private val furnitureTitle: TextView
    private val furnitureInfo: ConstraintLayout
    private val furnitureVendor: TextView
    private val furnitureCollection: TextView
    private val furniturePriceTitle: TextView
    private val furniturePrice: TextView
    private val furnitureCompareButton: Button

    init {
        inflate(context, R.layout.furniture_card, this)

        furnitureImage = findViewById(R.id.furniture_image)
        furnitureTitle = findViewById(R.id.furniture_title)
        furnitureInfo = findViewById(R.id.furniture_info)
        furnitureVendor = findViewById(R.id.furniture_vendor)
        furnitureCollection = findViewById(R.id.furniture_collection)
        furniturePriceTitle = findViewById(R.id.furniture_price_title)
        furniturePrice = findViewById(R.id.furniture_price)
        furnitureCompareButton = findViewById(R.id.furniture_compare_button)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        return true
    }

    fun update(data: FurnitureCardData) {
        Picasso.get().load(data.imageUrl).into(furnitureImage)
        furnitureTitle.text = data.title
        furnitureVendor.text = data.vendorTitle
        furnitureCollection.text = data.collection
        furniturePrice.text = data.price
    }

    fun setCompareButtonOnClickListener(compareTo: () -> Unit) {
        furnitureCompareButton.setOnClickListener {
            compareTo()
        }
    }
}